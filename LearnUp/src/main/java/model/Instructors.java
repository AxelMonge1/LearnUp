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
public class Instructors {
    private ObjectId _id;
    private String name;
    private String email;
    private List<String> specialties;
    private Integer experienceYears;
    private String bio;
    private Contact contact;
    private List<ObjectId> coursesTaught;
    private Instant createdAt;
    private Instant updatedAt;

    public Instructors() {
    }

    public Instructors(ObjectId _id, String name, String email, List<String> specialties, Integer experienceYears, String bio, Contact contact, List<ObjectId> coursesTaught, Instant createdAt, Instant updatedAt) {
        this._id = _id;
        this.name = name;
        this.email = email;
        this.specialties = specialties;
        this.experienceYears = experienceYears;
        this.bio = bio;
        this.contact = contact;
        this.coursesTaught = coursesTaught;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSpecialties(List<String> specialties) {
        this.specialties = specialties;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public void setCoursesTaught(List<ObjectId> coursesTaught) {
        this.coursesTaught = coursesTaught;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public ObjectId getId() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getSpecialties() {
        return specialties;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public String getBio() {
        return bio;
    }

    public Contact getContact() {
        return contact;
    }

    public List<ObjectId> getCoursesTaught() {
        return coursesTaught;
    }
}
