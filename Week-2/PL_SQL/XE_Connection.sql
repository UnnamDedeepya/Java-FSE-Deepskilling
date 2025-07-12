BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE Transactions CASCADE CONSTRAINTS';
   EXECUTE IMMEDIATE 'DROP TABLE Accounts CASCADE CONSTRAINTS';
   EXECUTE IMMEDIATE 'DROP TABLE Loans CASCADE CONSTRAINTS';
   EXECUTE IMMEDIATE 'DROP TABLE Employees CASCADE CONSTRAINTS';
   EXECUTE IMMEDIATE 'DROP TABLE Customers CASCADE CONSTRAINTS';
EXCEPTION
   WHEN OTHERS THEN NULL; -- Ignore errors if tables don’t exist
END;
/

--creating schema

CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE
);

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER,
     LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
); 

-- inserting the data to the tables
-- Customers Table
INSERT ALL
  INTO Customers VALUES (1, 'Akshaya', TO_DATE('2005-03-05', 'YYYY-MM-DD'), 1000, SYSDATE)
  INTO Customers VALUES (2, 'Dedeepya', TO_DATE('2004-09-02', 'YYYY-MM-DD'), 1500, SYSDATE)
  INTO Customers VALUES (3, 'Lasya', TO_DATE('2005-11-12', 'YYYY-MM-DD'), 1700, SYSDATE)
  INTO Customers VALUES (4, 'Rishika', TO_DATE('1980-04-21', 'YYYY-MM-DD'), 2000, SYSDATE)
  INTO Customers VALUES (5, 'Akshara', TO_DATE('1899-08-30', 'YYYY-MM-DD'), 3000, SYSDATE)
  INTO Customers VALUES (6, 'Krishna', TO_DATE('1978-10-22', 'YYYY-MM-DD'), 32000, SYSDATE)
  INTO Customers VALUES (7, 'Praveen', TO_DATE('1994-02-07', 'YYYY-MM-DD'), 13000, SYSDATE)
SELECT * FROM dual;

-- Accounts Table
INSERT ALL
  INTO Accounts VALUES (101, 1, 'Savings', 1000, SYSDATE)
  INTO Accounts VALUES (102, 2, 'Checking', 1500, SYSDATE)
  INTO Accounts VALUES (103, 3, 'General', 1700, SYSDATE)
  INTO Accounts VALUES (104, 4, 'Savings', 1250, SYSDATE)
  INTO Accounts VALUES (105, 5, 'Checking', 1900, SYSDATE)
  INTO Accounts VALUES (106, 6, 'Savings', 28000, SYSDATE)
  INTO Accounts VALUES (107, 7, 'General', 105000, SYSDATE)
SELECT * FROM dual;

-- Transactions Table
INSERT ALL
  INTO Transactions VALUES (1, 101, SYSDATE, 200, 'Deposit')
  INTO Transactions VALUES (2, 102, SYSDATE, 300, 'Withdrawal')
  INTO Transactions VALUES (3, 103, SYSDATE, 800, 'Deposit')
  INTO Transactions VALUES (4, 104, SYSDATE, 500, 'Withdrawal')
  INTO Transactions VALUES (5, 105, SYSDATE, 700, 'Withdrawal')
  INTO Transactions VALUES (6, 106, SYSDATE, 1200, 'Deposit')
  INTO Transactions VALUES (7, 107, SYSDATE, 1000, 'Deposit')
SELECT * FROM dual;

-- Loans Table
INSERT ALL
  INTO Loans VALUES (1001, 1, 5000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 60))
  INTO Loans VALUES (1002, 2, 2100, 2, SYSDATE, ADD_MONTHS(SYSDATE, 12))
  INTO Loans VALUES (1003, 3, 3900, 9, SYSDATE, ADD_MONTHS(SYSDATE, 100))
  INTO Loans VALUES (1003, 4, 4300, 5, SYSDATE, ADD_MONTHS(SYSDATE, 20))
  INTO Loans VALUES (1003, 5, 2100, 4, SYSDATE, ADD_MONTHS(SYSDATE, 30))
  INTO Loans VALUES (1003, 6, 38000, 1, SYSDATE, ADD_MONTHS(SYSDATE, 19))
  INTO Loans VALUES (1003, 7, 29000, 3, SYSDATE, ADD_MONTHS(SYSDATE, 10))
SELECT * FROM dual;

-- Employees Table
INSERT ALL
  INTO Employees VALUES (100, 'Kathyayini', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'))
  INTO Employees VALUES (200, 'Bhuvana', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'))
  INTO Employees VALUES (300, 'Kavitha', 'Analyst', 80000, 'IT', TO_DATE('2014-02-11', 'YYYY-MM-DD'))
  INTO Employees VALUES (300, 'Dedeepya', 'UI/UX', 80000, 'IT', TO_DATE('2010-12-17', 'YYYY-MM-DD'))
  INTO Employees VALUES (300, 'Akshaya', 'Data Analyst', 80000, 'IT', TO_DATE('1989-09-21', 'YYYY-MM-DD'))
  INTO Employees VALUES (300, 'Teja', 'Tester', 80000, 'IT', TO_DATE('2000-02-19', 'YYYY-MM-DD'))
  INTO Employees VALUES (300, 'Krishna', 'Developer', 80000, 'IT', TO_DATE('2022-11-11', 'YYYY-MM-DD'))
SELECT * FROM dual;

commit;