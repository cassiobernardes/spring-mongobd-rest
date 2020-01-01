package com.mongodb.workshop_mongodb.dto;


import com.mongodb.workshop_mongodb.models.User;

import java.io.Serializable;

public class AuthorDTO implements Serializable {

    private String id;
    private String name;

    public AuthorDTO() {
    }

    public AuthorDTO(User user) {
        id = user.getId();
        this.name = user.getName();
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
}
