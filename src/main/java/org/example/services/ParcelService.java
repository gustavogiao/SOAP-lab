package org.example.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface ParcelService {

    @WebMethod
    int registerParcel(String sender, String destinationPlanet, double weight);

    @WebMethod
    String getParcelStatus(int id);

    @WebMethod
    double calculateDeliveryCost(double weight, double distance);
}
