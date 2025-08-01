--scenario-1: Safe Transfer of Funds Between Accounts

SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_account_id IN NUMBER,
    p_to_account_id   IN NUMBER,
    p_amount          IN NUMBER
) AS
    v_balance NUMBER;
BEGIN
    -- Check if source account has enough balance
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account_id;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account.');
    END IF;

    -- Deduct from source
    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_from_account_id;

    -- Add to destination
    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_to_account_id;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Funds transferred successfully.');

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error occurred: ' || SQLERRM);
END;
/

BEGIN
    SafeTransferFunds(101, 102, 1300);
    SafeTransferFunds(104, 107, 1000);
    SafeTransferFunds(106, 103, 80000);
END;
/

--Scenario 2: Error Handling During Salary Update

CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_emp_id     IN NUMBER,
    p_percentage IN NUMBER
) AS
    v_old_salary NUMBER;
BEGIN
    -- Fetch current salary
    SELECT Salary INTO v_old_salary
    FROM Employees
    WHERE EmployeeID = p_emp_id;

    -- Update salary by given percentage
    UPDATE Employees
    SET Salary = Salary + (Salary * p_percentage / 100)
    WHERE EmployeeID = p_emp_id;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Salary updated for Employee ID: ' || p_emp_id);

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: Employee ID ' || p_emp_id || ' does not exist.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
END;
/

BEGIN
    UpdateSalary(100, 10);  -- Increases salary by 10% for EmployeeID 100
    UpdateSalary(400, 15);
    UpdateSalary(1600, 25);
END;
/

--Scenario 3: Add New Customer with Integrity Check!

CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_cust_id    IN NUMBER,
    p_name       IN VARCHAR2,
    p_dob        IN DATE,
    p_balance    IN NUMBER
) AS
BEGIN
    -- Try to insert the new customer
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_cust_id, p_name, p_dob, p_balance, SYSDATE);

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Customer added successfully. ID: ' || p_cust_id);

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Error: Customer with ID ' || p_cust_id || ' already exists.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
END;
/

BEGIN
    AddNewCustomer(8, 'Charan', TO_DATE('1995-01-10', 'YYYY-MM-DD'), 2500);
    AddNewCustomer(9, 'Seetha', TO_DATE('1984-09-17', 'YYYY-MM-DD'), 14000);
    AddNewCustomer(1, 'Akshaya', TO_DATE('2005-03-05', 'YYYY-MM-DD'), 1000);
END;
/