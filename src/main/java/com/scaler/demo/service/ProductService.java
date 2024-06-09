package com.scaler.demo.service;


import com.scaler.demo.Model.Category;
import com.scaler.demo.Model.Product;

import java.util.List;

public interface ProductService {
     Product getProductById(Integer id);
     List<Product> getAllProducts();
     List<Category> getAllCategories();
     List<Product> getProductByCategory(String category);
     Product addProduct(String title, String desc, Double price, String imageUrl, String category);
     Product updateProduct(Integer id, String title, String desc, Double price, String imageUrl, String category);
     String deleteProduct(Integer id);
     Product updateProductById(Integer id, String title, String desc, Double price, String imageUrl, String category);
     Product deleteProductById(Integer id);
}
