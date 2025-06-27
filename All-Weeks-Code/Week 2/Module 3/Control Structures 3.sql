DECLARE
   CURSOR LOAN_CUR IS
      SELECT l.LOANID, l.CUSTOMERID, l.LOANAMOUNT, l.ENDDATE, c.NAME
      FROM LOANS l
      JOIN CUSTOMERS c ON l.CUSTOMERID = c.CUSTOMERID
      WHERE l.ENDDATE BETWEEN SYSDATE AND SYSDATE + 30;

BEGIN
   FOR LOAN_DUE IN LOAN_CUR LOOP
      DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || LOAN_DUE.NAME ||
                           ', your loan (ID: ' || LOAN_DUE.LOANID || 
                           ') of amount $' || LOAN_DUE.LOANAMOUNT ||
                           ' is due on ' || TO_CHAR(LOAN_DUE.ENDDATE, 'DD-MON-YYYY') ||
                           '. Please ensure timely repayment.');
   END LOOP;
   DBMS_OUTPUT.PUT_LINE('All Reminders Successfully Sent');
END;
