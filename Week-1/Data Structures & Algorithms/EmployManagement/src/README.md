# 🔄 1. Understand the Problem

🎯 Goal:
Create a basic Employee Management System using a fixed-size array (not ArrayList).

📌 Why Arrays?
Arrays are contiguous memory structures.

They allow fast access by index (O(1)).

But arrays have fixed size and inefficient insertion/deletion compared to dynamic structures like ArrayList or LinkedList.

# 📊 4. Analysis

| Operation    | Time Complexity     |
| ------------ | ------------------- |
| Add Employee | O(1)                |
| Search       | O(n)                |
| Delete       | O(n) (due to shift) |
| Display All  | O(n)                |

🧱 Limitations of Arrays:
Fixed size – can't grow dynamically

Shifting elements makes deletion inefficient

Use ArrayList or LinkedList for better flexibility in real apps

# Output of the Code

D:\Java\jdk-17\bin\java.exe "-javaagent:D:\IntelliJ IDEA Community Edition 2025.1.1.1\lib\idea_rt.jar=63819" -Dfile.encoding=UTF-8 -classpath "E:\Java-FSE-Deepskilling\Week-1\Data Structures & Algorithms\EmployeManagementSystem\out\production\EmployeManagementSystem" app.EmployeeApp
Enter max number of employees: 3

--- Employee Menu ---
1. Add Employee
2. Search Employee
3. Delete Employee
4. View All Employees
5. Exit
Choose option: 1
Employee ID: 1201
Name: Kathyayini
Position: HR
Salary: 50000
Employee added.

--- Employee Menu ---
1. Add Employee
2. Search Employee
3. Delete Employee
4. View All Employees
5. Exit
Choose option: 1
Employee ID: 1202
Name: Dedeepya
Position: Data Analyst
Salary: 35000
Employee added.

--- Employee Menu ---
1. Add Employee
2. Search Employee
3. Delete Employee
4. View All Employees
5. Exit
Choose option: 1
Employee ID: 1203
Name: Akshaya
Position: Software Developer
Salary: 40000
Employee added.

--- Employee Menu ---
1. Add Employee
2. Search Employee
3. Delete Employee
4. View All Employees
5. Exit
Choose option: 1
Employee ID: 1204
Name: Bhuvana
Position: UI/UX Developer
Salary: 55000
No space available.

--- Employee Menu ---
1. Add Employee
2. Search Employee
3. Delete Employee
4. View All Employees
5. Exit
Choose option: 2
Enter Employee ID to search: 1202
Employee found: 1

--- Employee Menu ---
1. Add Employee
2. Search Employee
3. Delete Employee
4. View All Employees
5. Exit
Choose option: 4
[ID: 1201, Name: Kathyayini, Role: HR, Salary: ₹50000.0]

[ID: 1202, Name: Dedeepya, Role: Data Analyst, Salary: ₹35000.0]

[ID: 1203, Name: Akshaya, Role: Software Developer, Salary: ₹40000.0]

--- Employee Menu ---
1. Add Employee
2. Search Employee
3. Delete Employee
4. View All Employees
5. Exit
Choose option: 3
Enter Employee ID to delete: 1202
Employee deleted.

--- Employee Menu ---
1. Add Employee
2. Search Employee
3. Delete Employee
4. View All Employees
5. Exit
Choose option: 4
[ID: 1201, Name: Kathyayini, Role: HR, Salary: ₹50000.0]

[ID: 1203, Name: Akshaya, Role: Software Developer, Salary: ₹40000.0]

--- Employee Menu ---
1. Add Employee
2. Search Employee
3. Delete Employee
4. View All Employees
5. Exit
Choose option: 5
Exiting...

Process finished with exit code 0
