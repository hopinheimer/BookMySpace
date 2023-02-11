package com.ohspaces.bookmyspace.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BookRequestModel implements Serializable {

    private static final long versionID = 21348923983823l;

    @JsonProperty(value ="product_id")
    private Long productId;

    @JsonProperty(value = "user_id")
    private Long userId;

    @JsonProperty(value = "start_date")
    private LocalDateTime startDate;

    @JsonProperty(value = "end_date")
    private LocalDateTime endDate;

}
