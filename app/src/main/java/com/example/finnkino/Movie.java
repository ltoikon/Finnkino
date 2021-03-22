package com.example.finnkino;

public class Movie {
    private String name;
    private double price;

    public Movie(String givenName, double givenPrice) {
        name = givenName;
        price = givenPrice;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
}