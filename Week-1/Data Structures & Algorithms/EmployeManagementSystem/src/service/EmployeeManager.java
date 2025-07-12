package service;

import model.Employee;

public class EmployeeManager {
    private Employee[] employees;
    private int count;

    public EmployeeManager(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }

    public boolean addEmployee(Employee emp) {
        if (count < employees.length) {
            employees[count++] = emp;
            return true;
        }
        return false; // No space
    }

    public int searchEmployee(String empId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equalsIgnoreCase(empId)) {
                return i;
            }
        }
        return -1;
    }

    public boolean deleteEmployee(String empId) {
        int index = searchEmployee(empId);
        if (index == -1) return false;

        for (int i = index; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[--count] = null;
        return true;
    }

    public void displayAll() {
        if (count == 0) {
            System.out.println("No employees in the system.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(employees[i]);
            }
        }
    }
}
