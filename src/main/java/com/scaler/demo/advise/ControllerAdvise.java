package com.scaler.demo.advise;

import com.scaler.demo.dto.ErrorDTO;
import com.scaler.demo.exception.CategoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ControllerAdvise {

    public ResponseEntity<ErrorDTO> handleCategoryNotFoundException(CategoryNotFoundException exception){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setCode("400");
        errorDTO.setMessage(exception.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }
}
