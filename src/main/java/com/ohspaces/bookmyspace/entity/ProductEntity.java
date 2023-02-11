package com.ohspaces.bookmyspace.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "product")
@Data
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "seat_number")
    private String seatNumber;

    @Column(name = "floor")
    private String floor;

    @Column(name = "shift")
    private String shift;

    @Column(name = "price")
    private Double price;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_date",updatable = false)
    private Timestamp created_date;

    @Column(name = "created_by",updatable = false)
    private String createdBy;

    @Column(name = "updated_date",updatable = false)
    private Timestamp updatedDate;

    @Column(name = "update_by",updatable = false)
    private String updateBy;

}



