package org.example.clients;

import jakarta.xml.ws.Service;
import org.example.services.TimeService;

import javax.xml.namespace.QName;
import java.net.URL;

public class TimeClient {

    public static void main(String[] args) throws Exception {

        URL wsdl = new URL("http://localhost:8080/timeService?wsdl");

        QName serviceName = new QName(
                "http://services.example.org/",
                "TimeServiceImplService"
        );

        Service service = Service.create(wsdl, serviceName);

        TimeService port = service.getPort(TimeService.class);

        System.out.println("Hora: " + port.getTime());
        System.out.println("Data: " + port.getDate());
        System.out.println("Data formatada: "
                + port.getDateTimeFormatted("dd.MM.yyyy HH:mm:ss"));
    }
}