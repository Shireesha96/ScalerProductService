package com.scaler.demo.repository;

import com.scaler.demo.Model.Category;
import com.scaler.demo.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    //JPA Query Methods
    // insert product
    Product save(Product product);

    // get all products
    List<Product> findAll();

    // get product by id
    Product getProductById(int id);

    List<Product> getProductByCategory(Category category);

    void deleteProductById(int id);

}
