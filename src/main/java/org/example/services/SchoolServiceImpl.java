package org.example.services;

import jakarta.jws.WebService;
import org.example.db.Database;
import org.example.models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "org.example.services.SchoolService")
public class SchoolServiceImpl implements SchoolService{

    @Override
    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        try(Connection connection = Database.getConnection()){

            String sql = "SELECT * FROM students";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Student student = new Student(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("course"), resultSet.getInt("age"));
                students.add(student);
            }
        }catch (Exception e){
            System.out.println("Error fetching students: " + e.getMessage());
        }
        return students;
    }

    @Override
    public Student getStudentById(int id) {
        try(Connection connection = Database.getConnection()){
            String sql = "SELECT * FROM students WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                return new Student(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("course"), resultSet.getInt("age"));
            }
        }catch (Exception e){
            System.out.println("Error fetching student: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void addStudent(String name, String course, int age) {
        try(Connection connection = Database.getConnection()){
            String sql = "INSERT INTO students (name, course, age) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, course);
            statement.setInt(3, age);

            statement.executeUpdate();
        }catch (Exception e){
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    @Override
    public void deleteStudent(int id){

        try(Connection conn = Database.getConnection()){

            String sql = "DELETE FROM students WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,id);
            ps.executeUpdate();

        }catch(Exception e){
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }
}
