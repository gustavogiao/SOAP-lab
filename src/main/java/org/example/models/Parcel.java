package org.example.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Parcel {

    private int id;
    private String sender;
    private String destinationPlanet;
    private double weight;
    private String status;

    public Parcel(){}

    public Parcel(int id,String sender,String destinationPlanet,double weight,String status){
        this.id=id;
        this.sender=sender;
        this.destinationPlanet=destinationPlanet;
        this.weight=weight;
        this.status=status;
    }

    public int getId(){return id;}
    public void setId(int id){this.id=id;}

    public String getSender(){return sender;}
    public void setSender(String sender){this.sender=sender;}

    public String getDestinationPlanet(){return destinationPlanet;}
    public void setDestinationPlanet(String destinationPlanet){this.destinationPlanet=destinationPlanet;}

    public double getWeight(){return weight;}
    public void setWeight(double weight){this.weight=weight;}

    public String getStatus(){return status;}
    public void setStatus(String status){this.status=status;}
}