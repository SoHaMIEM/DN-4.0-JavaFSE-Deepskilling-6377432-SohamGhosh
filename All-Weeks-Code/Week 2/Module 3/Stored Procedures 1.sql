CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    
   UPDATE ACCOUNTS
   SET BALANCE = BALANCE + (BALANCE * 0.01),
       LASTMODIFIED = SYSDATE
   WHERE UPPER(ACCOUNTTYPE) = 'SAVINGS';

   COMMIT;

   DBMS_OUTPUT.PUT_LINE('Monthly interest applied to Savings accounts.');

   DBMS_OUTPUT.PUT_LINE('Updated Savings Account Details:');
   FOR acc IN (
       SELECT ACCOUNTID, CUSTOMERID, ACCOUNTTYPE, BALANCE, LASTMODIFIED
       FROM ACCOUNTS
       WHERE UPPER(ACCOUNTTYPE) = 'SAVINGS'
   ) LOOP
       DBMS_OUTPUT.PUT_LINE('AccountID: ' || acc.ACCOUNTID ||
                            ', CustomerID: ' || acc.CUSTOMERID ||
                            ', Balance: $' || TO_CHAR(acc.BALANCE, '9999.99') ||
                            ', LastModified: ' || TO_CHAR(acc.LASTMODIFIED, 'DD-MON-YYYY HH24:MI:SS'));
   END LOOP;

EXCEPTION
   WHEN OTHERS THEN
      ROLLBACK;
      DBMS_OUTPUT.PUT_LINE('Error processing interest: ' || SQLERRM);
END;
/
BEGIN
    PROCESSMONTHLYINTEREST;
END;
/