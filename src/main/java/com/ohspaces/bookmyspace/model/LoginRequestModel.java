package com.ohspaces.bookmyspace.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class LoginRequestModel implements Serializable {
    private static final long versionID = -13489283778237433l;

    @JsonProperty("mobile")
    private String mobile;
    @JsonProperty("user_id")
    private Long userId;

}
