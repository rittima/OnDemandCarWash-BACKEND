package com.green.car.wash.company.admin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Ratings")
public class Ratings {

    @Id
    int id;
    //This will work as a foreign key to get all the ratings of specific washer
    String washerName;
    String comments;
    double Rating;

    //Default Constructor
    public Ratings(){

    }

    //Constructor
    public Ratings(int id, String washerName, String comments, double rating) {
        this.id = id;
        this.washerName=washerName;
        this.comments = comments;
        Rating = rating;
    }

    //Getter and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getWasherName() {
        return washerName;
    }
    public void setWasherName(String washerName) {
        this.washerName = washerName;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    public double getRating() {
        return Rating;
    }
    public void setRating(double rating) {
        Rating = rating;
    }
}
