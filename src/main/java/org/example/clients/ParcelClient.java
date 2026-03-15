package org.example.clients;

import jakarta.xml.ws.Service;
import org.example.services.ParcelService;

import javax.xml.namespace.QName;
import java.net.URL;

public class ParcelClient {
    public static void main(String[] args) throws Exception {

        URL wsdl = new URL("http://localhost:8080/parcelService?wsdl");
        QName qname = new QName(
                "http://services.example.org/",
                "ParcelServiceImplService"
        );

        Service service = Service.create(wsdl, qname);

        ParcelService port = service.getPort(ParcelService.class);

        int parcelId = port.registerParcel("Alice", "Mars", 5.0);
        System.out.println("Registered parcel with ID: " + parcelId);

        String status = port.getParcelStatus(parcelId);
        System.out.println("Parcel status: " + status);

        double cost = port.calculateDeliveryCost(5.5, 200);
        System.out.println("Delivery cost: " + cost);
    }
}
