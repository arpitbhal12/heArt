package com.backend.heArt.entity;

import java.util.Date;

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

    public String getDisplayPicture() {
        return displayPicture;
    }

    public void setDisplayPicture(String display_picture) {
        this.displayPicture = display_picture;
    }

    public String getCoverPicture() {
        return coverPicture;
    }

    public void setCoverPicture(String cover_picture) {
        this.coverPicture = cover_picture;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Set<Role> getRoles() {
//        return Roles;
//    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + role +
                '}';
    }

//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }
}
