-- File: ControlStructures.sql
-- Scenario 1: Apply 1% interest discount for customers above 60

SET SERVEROUTPUT ON;

DECLARE
    v_age NUMBER;
BEGIN
    FOR rec IN (
        SELECT c.CustomerID, l.LoanID, c.DOB, l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
    ) LOOP
        v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12);
        
        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = rec.LoanID;
            
            DBMS_OUTPUT.PUT_LINE('Updated interest for CustomerID: ' || rec.CustomerID);
        END IF;
    END LOOP;

    COMMIT;
END;
/


-- Scenario 2: Set IsVIP to TRUE for customers with balance over $10,000

ALTER TABLE Customers ADD IsVIP VARCHAR2(10);

BEGIN
    FOR rec IN (
        SELECT CustomerID, Balance
        FROM Customers
    ) LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE('Customer ' || rec.CustomerID || ' marked as VIP.');
        ELSE
            UPDATE Customers
            SET IsVIP = 'FALSE'
            WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;

    COMMIT;
END;
/

-- Scenario 3: Send Reminders for Loans Due in the Next 30 Days


BEGIN
    FOR rec IN (
        SELECT c.Name, l.LoanID, l.EndDate
        FROM Loans l
        JOIN Customers c ON c.CustomerID = l.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || rec.LoanID || ' for ' || rec.Name ||
                             ' is due on ' || TO_CHAR(rec.EndDate, 'YYYY-MM-DD'));
    END LOOP;
END;
/
