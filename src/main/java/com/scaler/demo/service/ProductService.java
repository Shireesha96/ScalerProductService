package com.scaler.demo.service;


import com.scaler.demo.Model.Category;
import com.scaler.demo.Model.Product;
import com.scaler.demo.exception.CategoryNotFoundException;

import java.util.List;

public interface ProductService {
     Product getProductById(Integer id);
     List<Product> getAllProducts();
     List<Category> getAllCategories();
     List<Product> getProductByCategory(String category);
     Product addProduct(String title, String desc, Double price, String imageUrl, String category) throws CategoryNotFoundException;
     Product updateProduct(Integer id, String title, String desc, Double price, String imageUrl, String category);
     String deleteProduct(Integer id);
     Product updateProductById(Integer id, String title, String desc, Double price, String imageUrl, String category);
     Product deleteProductById(Integer id);
     Category addCategory(String category);
     String deleteCategory(String category);
     List<Product> getPaginatedProducts(int pageNo, int pageSize);
}
