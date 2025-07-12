package controller;

import model.Student;
import view.StudentView;

public class StudentController {
    private Student student;
    private StudentView view;

    public StudentController(Student student, StudentView view) {
        this.student = student;
        this.view = view;
    }

    public void updateStudent(String name, String id, String grade) {
        student.setName(name);
        student.setId(id);
        student.setGrade(grade);
    }

    public void showStudent() {
        view.displayStudentDetails(student);
    }
}
