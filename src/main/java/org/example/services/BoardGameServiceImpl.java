package org.example.services;

import jakarta.jws.WebService;
import org.example.db.Database;
import org.example.models.BoardGame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "org.example.services.BoardGameService")
public class BoardGameServiceImpl implements BoardGameService{

    @Override
    public void addBoardGame(int id, String name, int players, String genre, int year) {

        try(Connection conn = Database.getConnection()){

            String sql = "INSERT INTO boardgames (name, players, genre, year) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, name);
            stmt.setInt(2, players);
            stmt.setString(3, genre);
            stmt.setInt(4, year);

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error adding board game: " + e.getMessage());
        }

    }

    @Override
    public void deleteBoardGame(int id) {

        try(Connection conn = Database.getConnection()){
            String sql = "DELETE FROM boardgames WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error deleting board game: " + e.getMessage());
        }
    }

    @Override
    public void updateBoardGame(int id, String name, int players, String genre, int year) {

        try(Connection conn = Database.getConnection()){

            String sql = "UPDATE boardgames SET name = ?, players = ?, genre = ?, year = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, name);
            stmt.setInt(2, players);
            stmt.setString(3, genre);
            stmt.setInt(4, year);
            stmt.setInt(5, id);

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error updating board game: " + e.getMessage());
        }
    }

    @Override
    public BoardGame getBoardGame(int id) {
        try(Connection conn = Database.getConnection()){
            String sql = "SELECT * FROM boardgames WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return new BoardGame(rs.getInt("id"), rs.getString("name"), rs.getInt("players"), rs.getString("genre"), rs.getInt("year"));
            }

        } catch (Exception e) {
            System.out.println("Error retrieving board game: " + e.getMessage());
        }

        return null;
    }

    @Override
    public List<BoardGame> getAllBoardGames() {

        List<BoardGame> boardGames = new ArrayList<>();

        try(Connection conn = Database.getConnection()){

            String sql = "SELECT * FROM boardgames";
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                boardGames.add(new BoardGame(rs.getInt("id"), rs.getString("name"), rs.getInt("players"), rs.getString("genre"), rs.getInt("year")));
            }
        } catch (Exception e) {
            System.out.println("Error retrieving board games: " + e.getMessage());
        }

        return boardGames;
    }
}
