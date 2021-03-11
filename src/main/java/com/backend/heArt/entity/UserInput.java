package com.backend.heArt.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserInput {
    private Long id;

    private String name;

    private String username;

    private String email;

    private String password;

    private String displayPicture;

    private String coverPicture;

    private double rating;

    private String phone;

    private Roles role;

    private Date createdAt;

    private Date updatedAt;

    public UserInput() {
    }

    public UserInput(Long id, String name, String username, String email, String password, String displayPicture, String coverPicture, double rating, String phone, Roles role, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.displayPicture = displayPicture;
        this.coverPicture = coverPicture;
        this.rating = rating;
        this.phone = phone;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
