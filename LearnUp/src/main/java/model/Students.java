/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.Instant;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author axelm
 */
public class Students {
    private ObjectId _id;
    private String name;
    private String email;
    private List<EnrolledCourses> enrolledCourses;
    private List<String> interests;
    private Settings settings;
    private Instant createdAt;
    private Instant updatedAt;

    public Students() {
    }

    public Students(ObjectId _id, String name, String email, List<EnrolledCourses> enrolledCourses, List<String> interests, Settings settings, Instant createdAt, Instant updatedAt) {
        this._id = _id;
        this.name = name;
        this.email = email;
        this.enrolledCourses = enrolledCourses;
        this.interests = interests;
        this.settings = settings;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEnrolledCourses(List<EnrolledCourses> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public String getName() {
        return name;
    }

    public ObjectId getId() {
        return _id;
    }

    public String getEmail() {
        return email;
    }

    public List<EnrolledCourses> getEnrolledCourses() {
        return enrolledCourses;
    }

    public List<String> getInterests() {
        return interests;
    }

    public Settings getSettings() {
        return settings;
    }
}
