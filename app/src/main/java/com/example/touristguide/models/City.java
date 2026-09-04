package com.example.touristguide.models;

public class City {

    private String id;
    private String name;
    private String state;
    private String description;
    private boolean featured;

    public City() {
        // Required empty constructor for Firestore
    }

    public City(String id, String name, String state,
                String description, boolean featured) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.description = description;
        this.featured = featured;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }
}