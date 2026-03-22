package org.example.services;

import jakarta.jws.WebService;
import org.example.db.Database;
import org.example.models.Reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "org.example.services.ReservationService")
public class ReservationServiceImpl implements ReservationService{
    @Override
    public int createReservation(String passengerName, String originPlanet, String destinationPlanet, String travelDate, double price) {

        try(Connection conn = Database.getConnection()){
            String sql = "INSERT INTO reservations (passengerName, originPlanet, destinationPlanet, travelDate, price) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setString(1, passengerName);
            stmt.setString(2, originPlanet);
            stmt.setString(3, destinationPlanet);
            stmt.setString(4, travelDate);
            stmt.setDouble(5, price);

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                return rs.getInt(1);
            }

        }catch (Exception e){
            System.out.println("Error reserving space: " + e.getMessage());
        }
        return -1;
    }

    @Override
    public Reservation getReservation(int id) {
        try(Connection conn = Database.getConnection()){
            String sql = "SELECT * FROM reservations WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                Reservation res = new Reservation();
                res.setId(rs.getInt("id"));
                res.setPassengerName(rs.getString("passengerName"));
                res.setOriginPlanet(rs.getString("originPlanet"));
                res.setDestinationPlanet(rs.getString("destinationPlanet"));
                res.setTravelDate(rs.getString("travelDate"));
                res.setPrice(rs.getDouble("price"));
                return res;
            }
        }catch (Exception e){
            System.out.println("Error fetching reservation: " + e.getMessage());
        }
        throw new RuntimeException("Reservation not found with ID: " + id);
    }

    @Override
    public List<Reservation> getAllReservations() {
        try(Connection conn = Database.getConnection()){

            List<Reservation> reservations = new ArrayList<>();

            String sql = "SELECT * FROM reservations";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Reservation res = new Reservation();
                res.setId(rs.getInt("id"));
                res.setPassengerName(rs.getString("passengerName"));
                res.setOriginPlanet(rs.getString("originPlanet"));
                res.setDestinationPlanet(rs.getString("destinationPlanet"));
                res.setTravelDate(rs.getString("travelDate"));
                res.setPrice(rs.getDouble("price"));
                reservations.add(res);
            }

            return reservations;
        }catch (Exception e){
            System.out.println("Error fetching reservations: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public void updateReservationPrice(int id, double newPrice) {
        try(Connection conn = Database.getConnection()){
            String sql = "UPDATE reservations SET price = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, newPrice);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Reservation price updated successfully.");
        }catch (Exception e){
            System.out.println("Error updating reservation price: " + e.getMessage());
        }
    }

    @Override
    public void deleteReservation(int id) {
        try(Connection conn = Database.getConnection()) {
            String sql = "DELETE FROM reservations WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Reservation deleted successfully.");
        }catch (Exception e){
            System.out.println("Error deleting reservation: " + e.getMessage());
        }
    }
}
