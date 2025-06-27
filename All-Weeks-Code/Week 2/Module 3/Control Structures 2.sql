ALTER TABLE CUSTOMERS
ADD IS_VIP BOOLEAN DEFAULT FALSE;


DECLARE
    CURSOR CUST_CUR IS
        SELECT CUSTOMERID,NAME,BALANCE
        FROM CUSTOMERS;

    updated_count NUMBER := 0;
BEGIN
    FOR CUST IN CUST_CUR LOOP
        IF CUST.BALANCE > 10000 THEN
            UPDATE CUSTOMERS
            SET IS_VIP = TRUE
            WHERE CUSTOMERID = CUST.CUSTOMERID;
            DBMS_OUTPUT.PUT_LINE('Customer Id:' || CUST.CUSTOMERID || '- Customer Name:' || CUST.NAME || ' got promoted');

            updated_count := updated_count + 1;
        END IF;
    END LOOP;

    DBMS_OUTPUT.PUT_LINE(updated_count || ' customers promoted to VIP.');
END;
/