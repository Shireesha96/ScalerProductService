package com.scaler.demo.repository;

import com.scaler.demo.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findByName(String name);

    Category save(Category category);

    List<Category> findAll();

    void deleteByName(String categoryName);
}
