package org.example.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.example.models.Task;

import java.util.List;

@WebService
public interface TaskService {
    @WebMethod
    void createTask(String title, String description, String status);

    @WebMethod
    Task getTask(int id);

    @WebMethod
    List<Task> getAllTasks();

    @WebMethod
    void updateTask(int id, String title, String description, String status);

    @WebMethod
    void deleteTask(int id);
}
