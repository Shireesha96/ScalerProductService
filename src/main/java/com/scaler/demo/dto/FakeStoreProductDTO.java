package com.scaler.demo.dto;

import com.scaler.demo.Model.Category;
import com.scaler.demo.Model.Product;
import lombok.Getter;
import lombok.Setter;

/*
//output
            {
id:1,
title:'...',
price:'...',
category:'...',
description:'...',
image:'...'
        }

 */
@Getter
@Setter
public class FakeStoreProductDTO {
    private Integer id;
    private String title;
    private String description;
    private String price;
    private String image;
    private String category;


    public Product ConverToProduct(){
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageURL(image);

        Category c = new Category();
        c.setName(category);
        product.setCategory(c);

        return product;
    }

}
