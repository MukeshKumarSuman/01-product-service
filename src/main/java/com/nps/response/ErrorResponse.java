package com.nps.response;

import lombok.Data;

@Data
public class ErrorResponse {
    private String code;
    private String title;
    private String description;
}
