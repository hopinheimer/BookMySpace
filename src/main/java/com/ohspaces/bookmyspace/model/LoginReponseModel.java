package com.ohspaces.bookmyspace.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class LoginReponseModel implements Serializable {
    private static final long versionID = -1982372928382923L;
    @JsonProperty("mobile")
    private String mobile;

}
