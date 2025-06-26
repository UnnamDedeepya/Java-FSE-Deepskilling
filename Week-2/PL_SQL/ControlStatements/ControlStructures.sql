-- File: Exercise1_ControlStructures.sql
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
