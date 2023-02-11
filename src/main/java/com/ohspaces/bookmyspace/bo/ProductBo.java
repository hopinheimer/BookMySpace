package com.ohspaces.bookmyspace.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProductBo implements Serializable {

    @JsonProperty(value = "product_id")
    private Long productid;

    @JsonProperty(value = "seat_number")
    private String seatNumber;

    @JsonProperty(value = "floor")
    private String floor;

    @JsonProperty(value = "shift")
    private String shift;

    @JsonProperty(value = "price")
    private Double price;

    @JsonProperty(value = "is_active")
    private Boolean isActive;

}
