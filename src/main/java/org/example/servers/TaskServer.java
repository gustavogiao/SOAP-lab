package org.example.servers;

import jakarta.xml.ws.Endpoint;
import org.example.services.TaskServiceImpl;

public class TaskServer {

    public static void main(String[] args){

        String url="http://localhost:8080/taskService";

        Endpoint.publish(url,new TaskServiceImpl());

        System.out.println("SOAP Server started at "+url);
        System.out.println("WSDL available at "+url+"?wsdl");
    }
}