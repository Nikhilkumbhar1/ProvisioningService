package com.provisioning.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class User {
    @Id
    private Integer userID;
    private String name;
    private Date creationDate;
    private boolean isActive;
    private Date dateOfBirth;
    private String gender;
    private Long contact;
    private String mail;


}
