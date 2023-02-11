package com.ohspaces.bookmyspace.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name ="user")
@Entity
@Data

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "pan_card")
    private String panCard;

    @Column(name = "aadhar_card")
    private String aadharCard;

    @Column(name = "phone")
    private String phone;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_date")
    private Timestamp created_date;

    @Column(name ="created_by")
    private String createdBy;

    @Column(name = "updated_date")
    private Timestamp updatedDate;

    @Column(name = "update_by")
    private String updateBy;
}


//User_profile
//User_id
//Phone
//First_name
//Last_name
//Is_active
//Pan_card
//aadhar_card
//Created_date
//Created_by
//Updated_date
//update_by