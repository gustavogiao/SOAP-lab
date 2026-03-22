package org.example.models;

public class Reservation {
    private int id;
    private String passengerName;
    private String originPlanet;
    private String destinationPlanet;
    private String travelDate;
    private double price;

    public Reservation(){}

    public Reservation(int id,String passengerName,String originPlanet,String destinationPlanet,String travelDate,double price){
        this.id=id;
        this.passengerName=passengerName;
        this.originPlanet=originPlanet;
        this.destinationPlanet=destinationPlanet;
        this.travelDate=travelDate;
        this.price=price;
    }

    public int getId(){return id;}
    public void setId(int id){this.id=id;}

    public String getPassengerName(){return passengerName;}
    public void setPassengerName(String passengerName){this.passengerName=passengerName;}

    public String getOriginPlanet(){return originPlanet;}
    public void setOriginPlanet(String originPlanet){this.originPlanet=originPlanet;}

    public String getDestinationPlanet(){return destinationPlanet;}
    public void setDestinationPlanet(String destinationPlanet){this.destinationPlanet=destinationPlanet;}

    public String getTravelDate(){return travelDate;}
    public void setTravelDate(String travelDate){this.travelDate=travelDate;}

    public double getPrice(){return price;}
    public void setPrice(double price){this.price=price;}
}
