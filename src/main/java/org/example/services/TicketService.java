package org.example.services;

import java.util.List;

import org.example.models.Ticket;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface TicketService {
    @WebMethod
    List<Ticket> getAllTickets();

    @WebMethod
    Ticket getTicketById(int id);

    @WebMethod
    void createTicket(String customer, String movie, String room, int seats, String showDate, double price);

    @WebMethod
    void updateSeats(int id, int seats);

    @WebMethod
    void deleteTicket(int id);
}
