/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.Instant;

/**
 *
 * @author axelm
 */
public class Review {
    private Integer rating;
    private String comment;
    private Instant date;

    public Review() {
    }

    public Review(Integer rating, String comment, Instant date) {
        this.rating = rating;
        this.comment = comment;
        this.date = date;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Integer getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public Instant getDate() {
        return date;
    }
}
