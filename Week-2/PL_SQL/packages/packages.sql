--Scenario 1: CustomerManagement Package

-- Step 1: Create the Package Specification

SET SERVEROUTPUT ON;

BEGIN 
EXECUTE IMMEDIATE 'DROP PACKAGE CustomerManagement';
EXECUTE IMMEDIATE 'DROP PACKAGE EmployeeManagement';
EXECUTE IMMEDIATE 'DROP PACKAGE AccountOperations';
EXECUTE IMMEDIATE 'DROP PROCEDURE AddCustomer';
EXECUTE IMMEDIATE 'DROP PROCEDURE UpdateCustomer';
EXCEPTION 
WHEN OTHERS THEN NULL; 
END;
/

-- Clear test data
DELETE FROM Customers WHERE CustomerID = 10; --to get output everytime correctly
DELETE FROM Employees WHERE EmployeeID = 800; --to get output everytime correctly
COMMIT;


CREATE OR REPLACE PACKAGE CustomerManagement IS
    PROCEDURE AddCustomer(
        p_cust_id   IN NUMBER,
        p_name      IN VARCHAR2,
        p_dob       IN DATE,
        p_balance   IN NUMBER
    );

    PROCEDURE UpdateCustomer(
        p_cust_id   IN NUMBER,
        p_name      IN VARCHAR2,
        p_balance   IN NUMBER
    );

    FUNCTION GetCustomerBalance(
        p_cust_id IN NUMBER
    ) RETURN NUMBER;
END CustomerManagement;
/

--Step 2: Create the Package Body

CREATE OR REPLACE PACKAGE BODY CustomerManagement IS

    PROCEDURE AddCustomer(
        p_cust_id   IN NUMBER,
        p_name      IN VARCHAR2,
        p_dob       IN DATE,
        p_balance   IN NUMBER
    ) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (p_cust_id, p_name, p_dob, p_balance, SYSDATE);

        DBMS_OUTPUT.PUT_LINE('Customer added: ' || p_name);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Error: Customer ID already exists.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
    END;

    PROCEDURE UpdateCustomer(
        p_cust_id   IN NUMBER,
        p_name      IN VARCHAR2,
        p_balance   IN NUMBER
    ) IS
    BEGIN
        UPDATE Customers
        SET Name = p_name,
            Balance = p_balance,
            LastModified = SYSDATE
        WHERE CustomerID = p_cust_id;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('Error: No customer with ID ' || p_cust_id);
        ELSE
            DBMS_OUTPUT.PUT_LINE('Customer updated: ' || p_name);
        END IF;
    END;

    FUNCTION GetCustomerBalance(
        p_cust_id IN NUMBER
    ) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance
        FROM Customers
        WHERE CustomerID = p_cust_id;

        RETURN v_balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Customer not found.');
            RETURN NULL;
    END;

END CustomerManagement;
/

--check with inputs

-- Add a customer
BEGIN
    CustomerManagement.AddCustomer(10, 'Meghana', TO_DATE('1998-03-22', 'YYYY-MM-DD'), 2500);
END;
/
-- Update a customer

BEGIN
    CustomerManagement.UpdateCustomer(10, 'Meghana Reddy', 3000);
END;
/

--Get a customer balance

DECLARE
    v_bal NUMBER;
BEGIN
    v_bal := CustomerManagement.GetCustomerBalance(10);
    DBMS_OUTPUT.PUT_LINE('Customer Balance: ₹' || v_bal);
END;
/



--Scenario 2: EmployeeManagement Package

--Step 1: Package Specification

CREATE OR REPLACE PACKAGE EmployeeManagement IS
    PROCEDURE HireEmployee(
        p_emp_id     IN NUMBER,
        p_name       IN VARCHAR2,
        p_position   IN VARCHAR2,
        p_salary     IN NUMBER,
        p_department IN VARCHAR2,
        p_hire_date  IN DATE
    );

    PROCEDURE UpdateEmployee(
        p_emp_id     IN NUMBER,
        p_position   IN VARCHAR2,
        p_department IN VARCHAR2
    );

    FUNCTION GetSalary(
        p_emp_id IN NUMBER
    ) RETURN NUMBER;
END EmployeeManagement;
/

--Step 2: Package Body

CREATE OR REPLACE PACKAGE BODY EmployeeManagement IS

    PROCEDURE HireEmployee(
        p_emp_id     IN NUMBER,
        p_name       IN VARCHAR2,
        p_position   IN VARCHAR2,
        p_salary     IN NUMBER,
        p_department IN VARCHAR2,
        p_hire_date  IN DATE
    ) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_emp_id, p_name, p_position, p_salary, p_department, p_hire_date);

        DBMS_OUTPUT.PUT_LINE('Employee hired: ' || p_name);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Error: Employee ID already exists.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
    END;

    PROCEDURE UpdateEmployee(
        p_emp_id     IN NUMBER,
        p_position   IN VARCHAR2,
        p_department IN VARCHAR2
    ) IS
    BEGIN
        UPDATE Employees
        SET Position = p_position,
            Department = p_department
        WHERE EmployeeID = p_emp_id;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('No employee found with ID ' || p_emp_id);
        ELSE
            DBMS_OUTPUT.PUT_LINE('Employee updated: ID ' || p_emp_id);
        END IF;
    END;

    FUNCTION GetSalary(
        p_emp_id IN NUMBER
    ) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary INTO v_salary
        FROM Employees
        WHERE EmployeeID = p_emp_id;

        RETURN v_salary;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No employee found with ID ' || p_emp_id);
            RETURN NULL;
    END;

END EmployeeManagement;
/

--Hire a new employee:

BEGIN
    EmployeeManagement.HireEmployee(800, 'Varsha', 'QA Engineer', 48000, 'IT', TO_DATE('2024-01-10', 'YYYY-MM-DD'));
END;
/

--Update employee’s role and department:

BEGIN
    EmployeeManagement.UpdateEmployee(800, 'Senior QA Engineer', 'QA');
END;
/

--Get salary:


DECLARE
    v_sal NUMBER;
BEGIN
    v_sal := EmployeeManagement.GetSalary(800);
    DBMS_OUTPUT.PUT_LINE('Employee Salary: ₹' || v_sal);
END;
/


--Scenario 3: AccountOperations Package
-- Step 1: Create the Package Specification

CREATE OR REPLACE PACKAGE AccountOperations IS
    PROCEDURE OpenAccount(
        p_acc_id     IN NUMBER,
        p_cust_id    IN NUMBER,
        p_type       IN VARCHAR2,
        p_balance    IN NUMBER
    );

    PROCEDURE CloseAccount(
        p_acc_id IN NUMBER
    );

    FUNCTION GetTotalBalance(
        p_cust_id IN NUMBER
    ) RETURN NUMBER;
END AccountOperations;
/

--Step 2: Create the Package Body

CREATE OR REPLACE PACKAGE BODY AccountOperations IS

    PROCEDURE OpenAccount(
        p_acc_id     IN NUMBER,
        p_cust_id    IN NUMBER,
        p_type       IN VARCHAR2,
        p_balance    IN NUMBER
    ) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_acc_id, p_cust_id, p_type, p_balance, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Account opened: ID ' || p_acc_id);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Error: Account ID already exists.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
    END;

    PROCEDURE CloseAccount(
        p_acc_id IN NUMBER
    ) IS
    BEGIN
        DELETE FROM Accounts
        WHERE AccountID = p_acc_id;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('No account found with ID ' || p_acc_id);
        ELSE
            DBMS_OUTPUT.PUT_LINE('Account closed: ID ' || p_acc_id);
        END IF;
    END;

    FUNCTION GetTotalBalance(
        p_cust_id IN NUMBER
    ) RETURN NUMBER IS
        v_total NUMBER := 0;
    BEGIN
        SELECT SUM(Balance)
        INTO v_total
        FROM Accounts
        WHERE CustomerID = p_cust_id;

        RETURN NVL(v_total, 0);
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN 0;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
            RETURN 0;
    END;

END AccountOperations;
/

--Open a new account

BEGIN
    AccountOperations.OpenAccount(201, 2, 'Savings', 2500);
END;
/

--Close an account

BEGIN
    AccountOperations.CloseAccount(201);
END;
/

--Get total balance for a customer


DECLARE
    v_total NUMBER;
BEGIN
    v_total := AccountOperations.GetTotalBalance(2);
    DBMS_OUTPUT.PUT_LINE('Total balance for Customer 2: ₹' || v_total);
END;
/
