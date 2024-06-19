package com.scaler.demo.service;

import com.scaler.demo.Model.Category;
import com.scaler.demo.Model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService {
    @Override
    public Product getProductById(Integer id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public List<Category> getAllCategories() {
        return List.of();
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        return List.of();
    }

    @Override
    public Product addProduct(String title, String desc, Double price, String imageUrl, String category) {
        return null;
    }

    @Override
    public Product updateProduct(Integer id, String title, String desc, Double price, String imageUrl, String category) {
        return null;
    }

    @Override
    public String deleteProduct(Integer id) {
        return "";
    }

    @Override
    public Product updateProductById(Integer id, String title, String desc, Double price, String imageUrl, String category) {
        return null;
    }

    @Override
    public Product deleteProductById(Integer id) {
        return null;
    }
}
