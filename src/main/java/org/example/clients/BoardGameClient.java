package org.example.clients;

import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;

import org.example.models.BoardGame;
import org.example.services.BoardGameService;

import jakarta.xml.ws.Service;

public class BoardGameClient {
    public static void main(String[] args) throws Exception {
        URL wsdl = new URL("http://localhost:8080/boardGameService?wsdl");

        QName qname = new QName(
                "http://services.example.org/",
                "BoardGameServiceImplService"
        );

        Service service = Service.create(wsdl, qname);

        BoardGameService port = service.getPort(BoardGameService.class);

        port.addBoardGame(1,"Monopoly",4,"Strategy",2019);

        List<BoardGame> games = port.getAllBoardGames();

        for(BoardGame g:games){
            System.out.println(g.toString());
        }

        BoardGame g = port.getBoardGame(1);

        if(g!=null){
            System.out.println("Game: "+g.getName());
        }
    }
}
