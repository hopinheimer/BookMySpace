package com.ohspaces.bookmyspace.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class ApiError implements Serializable {

    private static final long serialVersionUID = 8801634819870313284L;

    private String code;

    private String message;
}
