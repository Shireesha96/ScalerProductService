package com.scaler.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorDTO {
    private String message;
    private String code;
}
