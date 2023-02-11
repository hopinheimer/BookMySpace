package com.ohspaces.bookmyspace.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class BookingResponseModel implements Serializable {

    @JsonProperty(value = "mem_id")
    private Long memId;

    @JsonProperty(value = "amount")
    private Double amount;

    @JsonProperty(value = "tax")
    private Double tax;

    @JsonProperty(value = "service_tax")
    private Double serviceTax;

    @JsonProperty(value = "total_amount")
    private Double totalAmount;
}
