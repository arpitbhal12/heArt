package com.backend.heArt.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

enum Gender{
    MALE, FEMALE, OTHER;
}

@Data
@Entity
@Table(name = "about")
public class About {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @DateTimeFormat
    private Date dob;

    private Gender gender;

    @OneToOne(mappedBy = "about")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public About() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Size(max = 500)
    private String bio;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
//    private User user;

}
