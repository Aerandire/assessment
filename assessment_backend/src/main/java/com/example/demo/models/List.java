package com.example.demo.models;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class List {
    private String postingID;
    private String postingDate;
    private String name;
    private String email;
    private String phone;
    private String title;
    private String image;
    private String description;

    public String getPostingID() {
        return postingID;
    }
    public void setPostingID(String postingID) {
        this.postingID = postingID;
    }
    public String getPostingDate() {
        return postingDate;
    }
    public void setPostingDate(String postingDate) {
        this.postingDate = postingDate;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public static List create(String postingID, String postingDate, String name, String email, String phone, String title, String description, String image){
        List l = new List();
        l.setPostingID(postingID);
        l.setPostingDate(postingDate);
        l.setName(name);
        l.setEmail(email);
        l.setPhone(phone);
        l.setTitle(title);
        l.setDescription(description);
        l.setImage(image);
        return l;
    }

    public JsonObject toJson(){
        return Json.createObjectBuilder()
            .add("postingID", postingID)
            .add("postingDate", postingDate)
            .add("name", name)
            .add("email", email)
            .add("phone", phone)
            .add("title", title)
            .add("description", description)
            .add("image", image)
            .build();
    }


}
