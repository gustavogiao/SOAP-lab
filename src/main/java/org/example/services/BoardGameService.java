package org.example.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.example.models.BoardGame;

import java.util.List;

@WebService
public interface BoardGameService {

    @WebMethod
    void addBoardGame(int id, String name, int players, String genre, int year);

    @WebMethod
    void deleteBoardGame(int id);

    @WebMethod
    void updateBoardGame(int id, String name, int players, String genre, int year);

    @WebMethod
    BoardGame getBoardGame(int id);

    @WebMethod
    List<BoardGame> getAllBoardGames();
}
