--Scenario 1: Update Customer’s LastModified on Account Update

SET SERVEROUTPUT ON;

CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
AFTER UPDATE ON Accounts
FOR EACH ROW
BEGIN
    UPDATE Customers
    SET LastModified = SYSDATE
    WHERE CustomerID = :NEW.CustomerID;
END;
/

UPDATE Accounts
SET Balance = Balance + 1000
WHERE AccountID = 101;

COMMIT;

SELECT CustomerID, Name, LastModified FROM Customers;


--scenario-2: Audit Log Trigger for Loans

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE LoanAudit CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN NULL; -- Ignore errors if tables don’t exist
END;
/

CREATE TABLE LoanAudit (
    AuditID       NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    LoanID        NUMBER,
    OldAmount     NUMBER,
    NewAmount     NUMBER,
    ModifiedDate  DATE
);

CREATE OR REPLACE TRIGGER LogLoanChanges
AFTER UPDATE ON Loans
FOR EACH ROW
WHEN (OLD.LoanAmount != NEW.LoanAmount)  -- Only log if LoanAmount is actually changed
BEGIN
    INSERT INTO LoanAudit (LoanID, OldAmount, NewAmount, ModifiedDate)
    VALUES (:OLD.LoanID, :OLD.LoanAmount, :NEW.LoanAmount, SYSDATE);
END;
/

UPDATE Loans
SET LoanAmount = 6000
WHERE LoanID = 1001;

COMMIT;

SELECT * FROM LoanAudit;

--Scenario 3: Enforce Business Rules on Deposits and Withdrawals

CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance NUMBER;
BEGIN
    -- Get current account balance
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = :NEW.AccountID;

    -- Rule 1: Withdrawal cannot exceed balance
    IF :NEW.TransactionType = 'Withdrawal' AND :NEW.Amount > v_balance THEN
        RAISE_APPLICATION_ERROR(-20001, 'Withdrawal exceeds current account balance.');
    END IF;

    -- Rule 2: Deposit amount must be positive
    IF :NEW.TransactionType = 'Deposit' AND :NEW.Amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be greater than 0.');
    END IF;
END;
/

-- Account 101 has 1000
INSERT INTO Transactions VALUES (10, 101, SYSDATE, 2000, 'Withdrawal');
INSERT INTO Transactions VALUES (11, 102, SYSDATE, 0, 'Deposit');
-- Valid deposit
INSERT INTO Transactions VALUES (12, 101, SYSDATE, 500, 'Deposit');

-- Valid withdrawal
INSERT INTO Transactions VALUES (13, 101, SYSDATE, 300, 'Withdrawal');
