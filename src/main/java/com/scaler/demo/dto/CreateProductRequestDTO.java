package com.scaler.demo.dto;

import com.scaler.demo.Model.Category;
import com.scaler.demo.Model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDTO {
    private String title;
    private String description;
    private Double price;
    private String image;
    private String category;
}
