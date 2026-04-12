package org.example.clients;

import java.util.List;

import org.example.reservation.client.Ticket;
import org.example.reservation.client.TicketService;
import org.example.reservation.client.TicketServiceImplService;

public class TicketClient {

    public static void main(String[] args) {

        TicketServiceImplService service = new TicketServiceImplService();
        TicketService port = service.getTicketServiceImplPort();

        // CREATE
        port.createTicket("Joao", "Avengers", "Room1", 2, "2026-04-12", 15.0);
        port.createTicket("Ana", "Batman", "Room2", 3, "2026-04-13", 20.0);

        // GET BY ID
        Ticket t = port.getTicketById(1);

        if (t != null) {
            System.out.println(
                    t.getId() + " | " +
                    t.getCustomerName() + " | " +
                    t.getMovieTitle() + " | " +
                    t.getRoom() + " | " +
                    t.getSeats() + " | " +
                    t.getShowDate() + " | " +
                    t.getPrice()
            );
        } else {
            System.out.println("Ticket not found");
        }

        // UPDATE
        port.updateSeats(1, 5);

        // LIST
        List<Ticket> tickets = port.getAllTickets();

        for (Ticket ticket : tickets) {
            System.out.println(
                    ticket.getId() + " | " +
                    ticket.getCustomerName() + " | " +
                    ticket.getMovieTitle() + " | " +
                    ticket.getRoom() + " | " +
                    ticket.getSeats() + " | " +
                    ticket.getShowDate() + " | " +
                    ticket.getPrice()
            );
        }

        // DELETE
        port.deleteTicket(2);

        // FINAL LIST
        tickets = port.getAllTickets();

        for (Ticket ticket : tickets) {
            System.out.println(
                    ticket.getId() + " | " +
                    ticket.getCustomerName() + " | " +
                    ticket.getMovieTitle()
            );
        }
    }
}