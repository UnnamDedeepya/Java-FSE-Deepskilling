--Scenario 1: Use an Explicit Cursor to Display Customer Info

SET SERVEROUTPUT ON;

DECLARE
    -- Cursor to fetch customer info
    CURSOR cust_cursor IS
        SELECT Name, DOB, Balance
        FROM Customers;

    v_name    Customers.Name%TYPE;
    v_dob     Customers.DOB%TYPE;
    v_balance Customers.Balance%TYPE;
    v_age     NUMBER;
BEGIN
    OPEN cust_cursor;
    LOOP
        FETCH cust_cursor INTO v_name, v_dob, v_balance;
        EXIT WHEN cust_cursor%NOTFOUND;

        v_age := CalculateAge(v_dob); -- use the function you created

        DBMS_OUTPUT.PUT_LINE('Name: ' || v_name ||
                             ', DOB: ' || TO_CHAR(v_dob, 'YYYY-MM-DD') ||
                             ', Balance: ₹' || v_balance ||
                             ', Age: ' || v_age);
    END LOOP;
    CLOSE cust_cursor;
END;
/

--Scenario 2: Apply Annual Fee to All Accounts

DECLARE
    CURSOR acc_cursor IS
        SELECT AccountID, Balance
        FROM Accounts;

    v_acc_id  Accounts.AccountID%TYPE;
    v_balance Accounts.Balance%TYPE;
    v_fee     CONSTANT NUMBER := 100;
BEGIN
    OPEN acc_cursor;
    LOOP
        FETCH acc_cursor INTO v_acc_id, v_balance;
        EXIT WHEN acc_cursor%NOTFOUND;

        IF v_balance >= v_fee THEN
            UPDATE Accounts
            SET Balance = Balance - v_fee,
                LastModified = SYSDATE
            WHERE AccountID = v_acc_id;

            DBMS_OUTPUT.PUT_LINE('Annual fee of ₹' || v_fee || ' deducted from Account ID: ' || v_acc_id);
        ELSE
            DBMS_OUTPUT.PUT_LINE('Account ID ' || v_acc_id || ' skipped due to low balance.');
        END IF;
    END LOOP;
    CLOSE acc_cursor;

    COMMIT;
END;
/

--Scenario 3: Update Loan Interest Rates Based on a New Policy


DECLARE
    CURSOR loan_cursor IS
        SELECT LoanID, LoanAmount, InterestRate
        FROM Loans;

    v_loan_id     Loans.LoanID%TYPE;
    v_amount      Loans.LoanAmount%TYPE;
    v_rate        Loans.InterestRate%TYPE;
BEGIN
    OPEN loan_cursor;
    LOOP
        FETCH loan_cursor INTO v_loan_id, v_amount, v_rate;
        EXIT WHEN loan_cursor%NOTFOUND;

        -- Apply new interest rate rules
        IF v_amount > 50000 THEN
            UPDATE Loans
            SET InterestRate = v_rate + 1
            WHERE LoanID = v_loan_id;

            DBMS_OUTPUT.PUT_LINE('Loan ' || v_loan_id || ': Interest increased by 1%');
        
        ELSIF v_amount < 10000 THEN
            UPDATE Loans
            SET InterestRate = v_rate - 0.5
            WHERE LoanID = v_loan_id;

            DBMS_OUTPUT.PUT_LINE('Loan ' || v_loan_id || ': Interest decreased by 0.5%');
        ELSE
            DBMS_OUTPUT.PUT_LINE('Loan ' || v_loan_id || ': No change in interest rate');
        END IF;
    END LOOP;
    CLOSE loan_cursor;

    COMMIT;
END;
/
