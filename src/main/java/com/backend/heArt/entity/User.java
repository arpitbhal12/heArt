package com.backend.heArt.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
@Data
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(max = 40)
    private String name;

    @NotBlank
    @Size(max = 15)
    private String username;

    @NaturalId
    @NotBlank
    @Size(max = 255)
    @Email
    private String email;

    @NotBlank
    @Size(max = 100)
    private String password;

    @Size(max = 255)
    private String displayPicture;

    @Size(max = 255)
    private String coverPicture;

    private double rating;

    @NaturalId
    @NotBlank
    @Size(min = 10, max = 12)
    private String phone;

    private Boolean enabled;

    private String confirmationToken;

    private Roles role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "about_id")
    private About about;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }


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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Roles getRole() {
        return role;
    }

    public About getAbout() {
        return about;
    }

    public void setAbout(About about) {
        this.about = about;
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

    public User() {

    }

    public User(String name, String username, String email, String phone, String password, Roles role, Boolean enabled, String confirmationToken) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
        this.confirmationToken = confirmationToken;
    }

    public User(Long id, String name, String username, String email, String password, String displayPicture, String coverPicture, double rating, String phone, Roles role, About about, Date createdAt, Date updatedAt) {
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
        this.about = about;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

}
