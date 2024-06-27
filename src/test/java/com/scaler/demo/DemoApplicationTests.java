package com.scaler.demo;

import com.scaler.demo.Model.Category;
import com.scaler.demo.Model.Product;
import com.scaler.demo.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Transactional
class DemoApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;


    @Test
    void contextLoads() {
    }

    @Test
    void testFetchType(){
        List<Category> categoryList = categoryRepository.findAll();
        for (Category category : categoryList) {
            System.out.println(category);
        }
        System.out.println(categoryList.get(0));

        List<Product> products = categoryList.get(0).getProducts();
        System.out.println(products);
    }
}
