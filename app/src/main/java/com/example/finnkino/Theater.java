package com.example.finnkino;

import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Theater {
    private String name;
    ArrayList<Movie> movies = new ArrayList<>();

    public Theater(){

    }

    public Theater(String givenName) {
        name = givenName;
        String[] names = {"Bond", "Herpderp the movie"};
        double [] prices = {12.8, 12.2};
        // Initialize the array
        // Add Bottle-objects to the array
        for(int i = 0;i<2;i++) {
            // Use the default constructor to create new Bottles

            Movie temp = new Movie(names[i], prices[i]);
            movies.add(temp);
        }
    }
    public void getMovies(TextView movieList) {
        String list;
        movieList.setText("");
        for (Movie bottlerino : movies) {
            movieList.append("Movie: " + bottlerino.getName() + "\nTicket price: " + bottlerino.getPrice() + "\n");
        }
    }

}



