package org.example.services;

import jakarta.jws.WebService;
import org.example.db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebService(endpointInterface = "org.example.services.ParcelService")
public class ParcelServiceImpl implements ParcelService{

    @Override
    public int registerParcel(String sender, String destinationPlanet, double weight) {
        try(Connection conn = Database.getConnection()){

            String sql = "INSERT INTO express_parcels (sender, destination_planet, weight, status) VALUES (?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setString(1, sender);
            stmt.setString(2, destinationPlanet);
            stmt.setDouble(3, weight);
            stmt.setString(4, "Processing");

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("Error registering parcel: " + e.getMessage());
        }

        return -1;
    }

    @Override
    public String getParcelStatus(int id) {
        try(Connection conn = Database.getConnection()){

            String sql = "SELECT status FROM express_parcels WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                return rs.getString("status");
            }

        } catch (Exception e) {
            System.out.println("Error getting parcel status: " + e.getMessage());
        }

        return "Parcel not found";
    }

    @Override
    public double calculateDeliveryCost(double weight, double distance) {
        double baseCost = 10.0;
        double weightFactor = 2 * weight;
        double distanceFactor = 0.5 * distance;
        return baseCost + weightFactor + distanceFactor;
    }
}
