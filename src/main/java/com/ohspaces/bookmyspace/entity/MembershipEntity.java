package com.ohspaces.bookmyspace.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "membership")
public class MembershipEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mem_id")
    private Long memId;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private ProductEntity products;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserEntity user;

    @Column(name = "start_date")
    private Timestamp startDate;

    @Column(name = "end_date")
    private Timestamp endDate;

    @Column(name = "created_date",updatable = false)
    private Timestamp created_date;

    @Column(name = "created_by",updatable = false)
    private String createdBy;

    @Column(name = "updated_date",updatable = false)
    private Timestamp updatedDate;

    @Column(name = "updated_by",updatable = false)
    private String updatedBy;


}
/*
* Membership_id
Product_id
Start_date
End_date
User_id
Is_active
Created_date
Created_by
Update_date
update_by

* */