package org.example.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.example.models.Reservation;

import java.util.List;

@WebService
public interface ReservationService {

    @WebMethod
    int createReservation(String passengerName, String originPlanet, String destinationPlanet, String travelDate, double price);

    @WebMethod
    Reservation getReservation(int id);

    @WebMethod
    List<Reservation> getAllReservations();

    @WebMethod
    void updateReservationPrice(int id, double newPrice);

    @WebMethod
    void deleteReservation(int id);
}
