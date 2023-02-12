package com.ohspaces.bookmyspace.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CheckoutRequest implements Serializable {
    private static final long versionID = 328392929383833l;

    @JsonProperty("mem_id")
    private Long memId;


}
