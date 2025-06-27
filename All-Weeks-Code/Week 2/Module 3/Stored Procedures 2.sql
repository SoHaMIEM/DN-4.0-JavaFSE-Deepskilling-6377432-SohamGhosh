CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
   p_department      IN EMPLOYEES.DEPARTMENT%TYPE,
   p_bonus_percent   IN NUMBER
) IS
BEGIN
   UPDATE EMPLOYEES
   SET SALARY = SALARY + (SALARY * p_bonus_percent / 100)
   WHERE UPPER(DEPARTMENT) = UPPER(p_department);
   COMMIT;
   DBMS_OUTPUT.PUT_LINE('Bonus of ' || p_bonus_percent || '% applied to department: ' || p_department);

   FOR emp IN (
      SELECT EMPLOYEEID, NAME, SALARY
      FROM EMPLOYEES
      WHERE UPPER(DEPARTMENT) = UPPER(p_department)
   ) LOOP
      DBMS_OUTPUT.PUT_LINE('EmployeeID: ' || emp.EMPLOYEEID ||
                           ', Name: ' || emp.NAME ||
                           ', New Salary: ' || TO_CHAR(emp.SALARY, '99999.99'));
   END LOOP;

EXCEPTION
   WHEN OTHERS THEN
      ROLLBACK;
      DBMS_OUTPUT.PUT_LINE('Error applying bonus: ' || SQLERRM);
END;
/
BEGIN
   UpdateEmployeeBonus(p_department => 'IT', p_bonus_percent => 10);
END;
/