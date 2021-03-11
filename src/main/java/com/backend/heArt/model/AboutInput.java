package com.backend.heArt.model;

import com.backend.heArt.entity.User;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class AboutInput<Gender> {
    private Long id;

    @DateTimeFormat
    @NotBlank
    private Date dob;

    private String bio;

    private User user;
}
