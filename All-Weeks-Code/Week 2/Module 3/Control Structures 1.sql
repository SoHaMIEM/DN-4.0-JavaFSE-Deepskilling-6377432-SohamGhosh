DECLARE
    CURSOR CUST_CUR IS
        SELECT C.CUSTOMERID, C.NAME, C.DOB, L.LOANID, L.LOANAMOUNT, L.INTERESTRATE
        FROM CUSTOMERS C
        JOIN LOANS L ON L.CUSTOMERID = C.CUSTOMERID;

    age NUMBER;
    new_interest LOANS.INTERESTRATE%TYPE;
BEGIN
    FOR CUST IN CUST_CUR LOOP
        age := CEIL(MONTHS_BETWEEN(SYSDATE, CUST.DOB) / 12);
        IF age > 60 THEN
            new_interest := CUST.INTERESTRATE - 1;
            IF new_interest < 0 THEN
                DBMS_OUTPUT.PUT_LINE('Customer ID: ' || CUST.CUSTOMERID || ' - Age: ' || age || 
                                     ' - Discount skipped to prevent negative interest rate.');
            ELSE
                UPDATE LOANS
                SET INTERESTRATE = new_interest
                WHERE LOANID = CUST.LOANID;
                DBMS_OUTPUT.PUT_LINE('Customer ID: ' || CUST.CUSTOMERID || ' - Age: ' || age ||
                                     ' - Interest rate reduced from ' || CUST.INTERESTRATE || 
                                     '% to ' || new_interest || '%');
            END IF;
        ELSE
            DBMS_OUTPUT.PUT_LINE('Customer ID: ' || CUST.CUSTOMERID || ' - Age: ' || age || ' - Not Eligible for Discount');
        END IF;
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Changes Successful');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error occurred: ' || SQLERRM);
END;
