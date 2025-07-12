--Scenario-1: Process Monthly Interest for All Savings Accounts

SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    FOR rec IN (
        SELECT AccountID, Balance
        FROM Accounts
        WHERE AccountType = 'Savings'
    ) LOOP
        -- Add 1% interest to the balance
        UPDATE Accounts
        SET Balance = Balance + (rec.Balance * 0.01),
            LastModified = SYSDATE
        WHERE AccountID = rec.AccountID;

        DBMS_OUTPUT.PUT_LINE('Interest applied to Account ID: ' || rec.AccountID);
    END LOOP;

    COMMIT;
END;
/

BEGIN
    ProcessMonthlyInterest;
END;
/

SELECT * FROM Accounts WHERE AccountType = 'Savings';


--scenario-2: Add Bonus to Employees by Department

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_dept     IN VARCHAR2,
    p_bonus_pct IN NUMBER
) AS
BEGIN
    FOR rec IN (
        SELECT EmployeeID, Salary
        FROM Employees
        WHERE Department = p_dept
    ) LOOP
        -- Apply bonus
        UPDATE Employees
        SET Salary = Salary + (rec.Salary * p_bonus_pct / 100)
        WHERE EmployeeID = rec.EmployeeID;

        DBMS_OUTPUT.PUT_LINE('Bonus applied to Employee ID: ' || rec.EmployeeID);
    END LOOP;

    COMMIT;
END;
/

BEGIN
    -- Apply 10% bonus to IT department
    UpdateEmployeeBonus('IT', 10);
    UpdateEmployeeBonus('HR', 20);
    
END;
/


--Scenario 3: Customer Fund Transfer 

CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account IN NUMBER,
    p_to_account   IN NUMBER,
    p_amount       IN NUMBER
) AS
    v_balance NUMBER;
BEGIN
    -- Get current balance of source account
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account;

    IF v_balance < p_amount THEN
        DBMS_OUTPUT.PUT_LINE('Transfer failed: insufficient balance in account ' || p_from_account);
        RETURN;
    END IF;

    -- Deduct from source account
    UPDATE Accounts
    SET Balance = Balance - p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_from_account;

    -- Add to destination account
    UPDATE Accounts
    SET Balance = Balance + p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_to_account;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Successfully transferred ' || p_amount || ' from ' || 
                         p_from_account || ' to ' || p_to_account);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: One of the accounts does not exist.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
        ROLLBACK;
END;
/

BEGIN
    TransferFunds(101, 102, 200);
    TransferFunds(105, 103, 3000);
    TransferFunds(108, 104, 15000);
END;
/