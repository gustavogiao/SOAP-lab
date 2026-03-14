package org.example.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.example.models.Student;

import java.util.List;

@WebService
public interface SchoolService {
    @WebMethod
    List<Student> getAllStudents();

    @WebMethod
    Student getStudentById(int id);

    @WebMethod
    void addStudent(String name, String course, int age);

    @WebMethod
    void deleteStudent(int id);
}
