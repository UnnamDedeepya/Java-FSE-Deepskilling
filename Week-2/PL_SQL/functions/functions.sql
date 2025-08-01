--Scenario 1: Calculate Customer Age

SET SERVEROUTPUT ON;

CREATE OR REPLACE FUNCTION CalculateAge(
    p_dob IN DATE
) RETURN NUMBER IS
    v_age NUMBER;
BEGIN
    v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
    RETURN v_age;
END;
/

SELECT 
    CustomerID, 
    Name, 
    DOB, 
    CalculateAge(DOB) AS Age
FROM Customers;

--Scenario 2: Calculate Monthly Installment

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_amount      IN NUMBER,
    p_rate        IN NUMBER,
    p_duration_yr IN NUMBER
) RETURN NUMBER IS
    v_monthly_rate NUMBER;
    v_months       NUMBER;
    v_emi          NUMBER;
BEGIN
    -- Convert duration to months
    v_months := p_duration_yr * 12;

    -- Avoid division by zero
    IF v_months = 0 THEN
        DBMS_OUTPUT.PUT_LINE('Error: Loan duration cannot be 0 years.');
        RETURN NULL;
    END IF;

    -- Convert annual interest rate to monthly decimal
    v_monthly_rate := p_rate / 12 / 100;

    IF v_monthly_rate = 0 THEN
        -- No interest
        v_emi := p_amount / v_months;
    ELSE
        -- Regular EMI formula
        v_emi := (p_amount * v_monthly_rate * POWER(1 + v_monthly_rate, v_months)) /
                 (POWER(1 + v_monthly_rate, v_months) - 1);
    END IF;

    RETURN ROUND(v_emi, 2);

EXCEPTION
    WHEN ZERO_DIVIDE THEN
        DBMS_OUTPUT.PUT_LINE('Error: Division by zero occurred.');
        RETURN NULL;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
        RETURN NULL;
END;
/


SELECT 
    LoanID,
    LoanAmount,
    InterestRate,
    ROUND(MONTHS_BETWEEN(EndDate, StartDate)/12) AS Years,
    CalculateMonthlyInstallment(LoanAmount, InterestRate, ROUND(MONTHS_BETWEEN(EndDate, StartDate)/12)) AS EMI
FROM Loans;


--Scenario 3: Check If Account Has Enough Balance

CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_account_id IN NUMBER,
    p_amount     IN NUMBER
) RETURN BOOLEAN IS
    v_balance NUMBER;
BEGIN
    -- Get account balance
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_account_id;

    -- Return TRUE if balance is sufficient
    RETURN v_balance >= p_amount;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: Account ID ' || p_account_id || ' not found.');
        RETURN FALSE;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
        RETURN FALSE;
END;
/



BEGIN
    FOR rec IN (
        SELECT c.CustomerID, c.Name, a.AccountID
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
    ) LOOP
        IF HasSufficientBalance(rec.AccountID, 2000) THEN
            DBMS_OUTPUT.PUT_LINE('Customer ' || rec.Name || ' has sufficient balance.');
        ELSE
            DBMS_OUTPUT.PUT_LINE('Customer ' || rec.Name || ' does NOT have sufficient balance.');
        END IF;
    END LOOP;
END;
/
