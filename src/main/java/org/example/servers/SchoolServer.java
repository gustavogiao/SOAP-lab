package org.example.servers;

import jakarta.xml.ws.Endpoint;
import org.example.services.SchoolServiceImpl;

public class SchoolServer {
    public static void main(String[] args) {
        String url = "http://localhost:8080/schoolService";
        Endpoint.publish(url,new SchoolServiceImpl());
        System.out.println("SOAP Server started at " + url);
        System.out.println("WSDL available at " + url + "?wsdl");
    }
}
