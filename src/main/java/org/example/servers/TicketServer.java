package org.example.servers;

import org.example.services.TicketServiceImpl;

import jakarta.xml.ws.Endpoint;

public class TicketServer {

    public static void main(String[] args){

        String url="http://localhost:8080/ticketService";

        Endpoint.publish(url,new TicketServiceImpl());

        System.out.println("SOAP Server started at "+url);
        System.out.println("WSDL available at "+url+"?wsdl");
    }
    
}
