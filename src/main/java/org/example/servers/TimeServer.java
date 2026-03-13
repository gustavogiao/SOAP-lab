package org.example.servers;

import jakarta.xml.ws.Endpoint;
import org.example.services.TimeServiceImpl;

public class TimeServer {
    public static void main(String[] args) {
        String url = "http://localhost:8080/timeService";
        Endpoint.publish(url, new TimeServiceImpl());

        System.out.println("SOAP server started at " + url);
        System.out.println("WSDL is available at " + url + "?wsdl");
    }
}
