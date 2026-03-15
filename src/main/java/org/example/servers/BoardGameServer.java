package org.example.servers;

import jakarta.xml.ws.Endpoint;
import org.example.services.BoardGameServiceImpl;

public class BoardGameServer {
    public static void main(String[] args) {
        String url = "http://localhost:8080/boardGameService";
        Endpoint.publish(url, new BoardGameServiceImpl());
        System.out.println("SOAP Server started at " + url);
        System.out.println("WSDL available at " + url + "?wsdl");
    }
}
