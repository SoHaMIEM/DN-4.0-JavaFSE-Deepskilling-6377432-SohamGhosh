CREATE OR REPLACE PROCEDURE TransferFunds (
   p_from_account_id IN ACCOUNTS.ACCOUNTID%TYPE,
   p_to_account_id   IN ACCOUNTS.ACCOUNTID%TYPE,
   p_amount          IN NUMBER
) IS
   v_from_balance ACCOUNTS.BALANCE%TYPE;
BEGIN
   SELECT BALANCE INTO v_from_balance
   FROM ACCOUNTS
   WHERE ACCOUNTID = p_from_account_id
   FOR UPDATE;

   IF v_from_balance < p_amount THEN
      DBMS_OUTPUT.PUT_LINE('Transfer failed: Insufficient balance.');
      RETURN;
   END IF;

   UPDATE ACCOUNTS
   SET BALANCE = BALANCE - p_amount,
       LASTMODIFIED = SYSDATE
   WHERE ACCOUNTID = p_from_account_id;

   UPDATE ACCOUNTS
   SET BALANCE = BALANCE + p_amount,
       LASTMODIFIED = SYSDATE
   WHERE ACCOUNTID = p_to_account_id;
   COMMIT;

   DBMS_OUTPUT.PUT_LINE('Transfer successful.');
   DBMS_OUTPUT.PUT_LINE('Updated account details:');

   FOR acc IN (
      SELECT ACCOUNTID, CUSTOMERID, ACCOUNTTYPE, BALANCE, LASTMODIFIED
      FROM ACCOUNTS
      WHERE ACCOUNTID = p_from_account_id OR ACCOUNTID = p_to_account_id
   ) LOOP
      DBMS_OUTPUT.PUT_LINE('AccountID: ' || acc.ACCOUNTID ||
                           ', CustomerID: ' || acc.CUSTOMERID ||
                           ', Type: ' || acc.ACCOUNTTYPE ||
                           ', Balance: $' || TO_CHAR(acc.BALANCE, '999999.99') ||
                           ', LastModified: ' || TO_CHAR(acc.LASTMODIFIED, 'DD-MON-YYYY HH24:MI:SS'));
   END LOOP;

EXCEPTION
   WHEN OTHERS THEN
      ROLLBACK;
      DBMS_OUTPUT.PUT_LINE('Transfer failed due to an error.');
END;
/
BEGIN
   TransferFunds(3, 1, 500);
END;
/
