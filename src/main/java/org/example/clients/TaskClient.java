package org.example.clients;

import jakarta.xml.ws.Service;
import org.example.models.Task;
import org.example.services.TaskService;

import javax.xml.namespace.QName;
import java.net.URL;
import java.util.List;

public class TaskClient {

    public static void main(String[] args) throws Exception{

        URL wsdl=new URL("http://localhost:8080/taskService?wsdl");

        QName qname=new QName(
                "http://services.example.org/",
                "TaskServiceImplService"
        );

        Service service=Service.create(wsdl,qname);

        TaskService port=service.getPort(TaskService.class);

        port.createTask("Study SOAP","Finish exercise","pending");

        List<Task> tasks=port.getAllTasks();

        for(Task t:tasks){
            System.out.println(t.getId()+" "+t.getTitle()+" "+t.getStatus());
        }

        Task t=port.getTask(1);

        if(t!=null){
            System.out.println("Task: "+t.getTitle());
        }
    }
}