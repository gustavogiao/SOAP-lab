package org.example.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Ticket {
    private int id;
    private String customerName;
    private String movieTitle;
    private String room;
    private int seats;
    private String showDate;
    private double price;

    public Ticket(){}

    public Ticket(int id, String customerName, String movieTitle, String room, int seats, String showDate, double price){
        this.id = id;
        this.customerName = customerName;
        this.movieTitle = movieTitle;
        this.room = room;
        this.seats = seats;
        this.showDate = showDate;
        this.price = price;
    }

    public int getId() { return id; }
    public String getCustomer() { return customerName; }
    public String getMovie() { return movieTitle; }
    public String getRoom() {return room;}
    public int getSeats() { return seats; }
    public String getShowDate() { return showDate; }
    public double getPrice() { return price; }

    public void setId(int id) {this.id = id;}
    public void setCustomer(String customer) {this.customerName = customer;}
    public void setMovie(String movie) {this.movieTitle = movie;}
    public void setRoom(String room) {this.room = room;}
    public void setSeats(int seats) { this.seats = seats; }
    public void setShowDate(String showDate) {this.showDate = showDate;}
    public void setPrice(double price) {this.price = price;} 
}
