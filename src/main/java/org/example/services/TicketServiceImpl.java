package org.example.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.example.db.Database;
import org.example.models.Ticket;

import jakarta.jws.WebService;

@WebService(endpointInterface = "org.example.services.TicketService")
public class TicketServiceImpl implements TicketService {

    @Override
    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = new ArrayList<>();

        try(Connection conn = Database.getConnection()){

            String sql = "SELECT * FROM tickets";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                tickets.add(new Ticket(
                    rs.getInt("id"),
                    rs.getString("customerName"),
                    rs.getString("movieTitle"),
                    rs.getString("room"),
                    rs.getInt("seats"),
                    rs.getString("showDate"),
                    rs.getDouble("price")
                ));
            }
        
        }catch(Exception e){
            System.out.println("Error fetching tickets: " + e.getMessage());
        }

        return tickets;
    }

    @Override
    public Ticket getTicketById(int id) {
        try(Connection conn = Database.getConnection()){
            String sql = "SELECT * FROM tickets WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return new Ticket(
                    rs.getInt("id"),
                    rs.getString("customerName"),
                    rs.getString("movieTitle"),
                    rs.getString("room"),
                    rs.getInt("seats"),
                    rs.getString("showDate"),
                    rs.getDouble("price")
                );
            }
        }catch(Exception e){
            System.out.println("Error fetching ticket: " + e.getMessage());
        }
        
        throw new RuntimeException("Ticket not found");

    }

    @Override
    public void createTicket(String customer, String movie, String room, int seats, String showDate, double price) {
        try(Connection conn = Database.getConnection()){

            String sql = "INSERT INTO tickets(customerName, movieTitle, room, seats, showDate, price) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, customer);
            ps.setString(2, movie);
            ps.setString(3, room);
            ps.setInt(4, seats);
            ps.setString(5, showDate);
            ps.setDouble(6, price);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Error creating a ticket: " + e.getMessage());
        }
    }

    @Override
    public void updateSeats(int id, int seats) {
        try(Connection conn = Database.getConnection()){

            String sql = "UPDATE tickets SET seats=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, seats);
            ps.setInt(2, id);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Error updating seats: " + e.getMessage());
        }
    }

    @Override
    public void deleteTicket(int id) {
        try(Connection conn = Database.getConnection()){

            String sql = "DELETE FROM tickets WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, id);
            ps.executeUpdate();

        }catch(Exception e){
            System.out.println("Error deleting a ticket: " + e.getMessage());
        }
    }
    
}
