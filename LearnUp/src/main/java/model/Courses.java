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
public class Courses {
    private ObjectId _id;
    private String title;
    private String description;
    private String category;
    private ObjectId instructorId;
    private Double price;
    private Double rating;
    private List<String> tags;
    private List<Modules> modules;
    private Instant createdAt;
    private Instant updatedAt;

    public Courses() {
    }

    public Courses(ObjectId _id, String title, String description, String category, ObjectId instructorId, Double price, Double rating, List<String> tags, List<Modules> modulos, Instant createdAt, Instant updatedAt) {
        this._id = _id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.instructorId = instructorId;
        this.price = price;
        this.rating = rating;
        this.tags = tags;
        this.modules = modulos;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setInstructorId(ObjectId instructorId) {
        this.instructorId = instructorId;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setModules(List<Modules> modules) {
        this.modules = modules;
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

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public ObjectId getInstructorId() {
        return instructorId;
    }

    public Double getPrice() {
        return price;
    }

    public Double getRating() {
        return rating;
    }

    public List<String> getTags() {
        return tags;
    }

    public List<Modules> getModules() {
        return modules;
    }
}
