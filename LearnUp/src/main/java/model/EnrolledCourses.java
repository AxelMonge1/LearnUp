/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.Instant;
import org.bson.types.ObjectId;

/**
 *
 * @author axelm
 */
public class EnrolledCourses {
    private ObjectId _id;
    private Instant enrollmentDate;
    private Double progress;
    private Review review;

    public EnrolledCourses() {
    }

    public EnrolledCourses(ObjectId _id, Instant enrollmentDate, Double progress, Review review) {
        this._id = _id;
        this.enrollmentDate = enrollmentDate;
        this.progress = progress;
        this.review = review;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public void setEnrollmentDate(Instant enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public ObjectId getId() {
        return _id;
    }

    public Instant getEnrollmentDate() {
        return enrollmentDate;
    }

    public Double getProgress() {
        return progress;
    }

    public Review getReview() {
        return review;
    }
}
