package org.example.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.example.db.Database;
import org.example.models.Task;

import jakarta.jws.WebService;

@WebService(endpointInterface = "org.example.services.TaskService")
public class TaskServiceImpl implements TaskService{

    public void createTask(String title,String description,String status){

        try(Connection conn = Database.getConnection()){

            String sql="INSERT INTO tasks(title,description,status) VALUES(?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);

            ps.setString(1,title);
            ps.setString(2,description);
            ps.setString(3,status);

            ps.executeUpdate();

        }catch(Exception e){
            System.out.println("Error creating task: "+e.getMessage());
        }
    }

    public Task getTask(int id){

        try(Connection conn = Database.getConnection()){

            String sql="SELECT * FROM tasks WHERE id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,id);

            ResultSet rs=ps.executeQuery();

            if(rs.next()){
                return new Task(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("status")
                );
            }

        }catch(Exception e){
            System.out.println("Error fetching task: "+e.getMessage());
        }

        return null;
    }

    public List<Task> getAllTasks(){

        List<Task> tasks=new ArrayList<>();

        try(Connection conn = Database.getConnection()){

            String sql="SELECT * FROM tasks";
            PreparedStatement ps=conn.prepareStatement(sql);

            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                tasks.add(new Task(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("status")
                ));
            }

        }catch(Exception e){
            System.out.println("Error fetching tasks: "+e.getMessage());
        }

        return tasks;
    }

    public void updateTask(int id,String title,String description,String status){

        try(Connection conn = Database.getConnection()){

            String sql="UPDATE tasks SET title=?,description=?,status=? WHERE id=?";
            PreparedStatement ps=conn.prepareStatement(sql);

            ps.setString(1,title);
            ps.setString(2,description);
            ps.setString(3,status);
            ps.setInt(4,id);

            ps.executeUpdate();

        }catch(Exception e){
            System.out.println("Error updating task: "+e.getMessage());
        }
    }

    public void deleteTask(int id){

        try(Connection conn = Database.getConnection()){

            String sql="DELETE FROM tasks WHERE id=?";
            PreparedStatement ps=conn.prepareStatement(sql);

            ps.setInt(1,id);
            ps.executeUpdate();

        }catch(Exception e){
            System.out.println("Error deleting task: "+e.getMessage());
        }
    }
}
