package com.scaler.demo.controller;

import com.scaler.demo.Model.Category;
import com.scaler.demo.Model.Product;
import com.scaler.demo.dto.CategoryResponseDTO;
import com.scaler.demo.dto.CreateProductRequestDTO;
import com.scaler.demo.dto.ProductResponseDTO;
import com.scaler.demo.service.FakeStoreService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.scaler.demo.service.ProductService;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }

    // Get Product By ID
    @GetMapping("/products/{id}")
    public ProductResponseDTO getProductById(@PathVariable("id") Integer id) {
        Product product = productService.getProductById(id);
        //System.out.println(product.getId());
        return product.convertToResponseDTO();
    }

    //Get All Products
    @GetMapping("/products")
    public List<ProductResponseDTO> getProducts(){
        List<ProductResponseDTO> responseDTOList = new ArrayList<>();
        List<Product> products = productService.getAllProducts();
        for(Product p : products){
            responseDTOList.add(p.convertToResponseDTO());
        }
        return responseDTOList;
    }

    //Get All Categories
    @GetMapping("/categories")
    public List<CategoryResponseDTO> getCategories(){
        List<CategoryResponseDTO> responseDTOList = new ArrayList<>();
        List<Category> categories = productService.getAllCategories();
        for(Category c : categories){
            responseDTOList.add(c.convertToResponseDTO());
        }
        return responseDTOList;
    }

    @GetMapping("products/category/{category}")
    public List<ProductResponseDTO> getProductsByCategory(@PathVariable("category") String category){
        List<ProductResponseDTO> responseDTOList = new ArrayList<>();
        List<Product> products = productService.getProductByCategory(category);
        for(Product p : products){
            responseDTOList.add(p.convertToResponseDTO());
        }
        return responseDTOList;
    }

    @PostMapping("/products")
    public ProductResponseDTO addProduct(@RequestBody CreateProductRequestDTO dto){
        Product product = productService.addProduct(dto.getTitle(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getImage(),
                dto.getCategory());
        return product.convertToResponseDTO();
    }

    @PatchMapping("/products/{id}")
    public  ProductResponseDTO updateProduct(@PathVariable("id") Integer id, @RequestBody CreateProductRequestDTO dto)
    {
        Product product = productService.updateProduct(id,
                dto.getTitle(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getImage(),
                dto.getCategory());

        return product.convertToResponseDTO();
    }

    @PutMapping("/products/exchange/{id}")
    public  ProductResponseDTO updateProductById(@PathVariable("id") Integer id, @RequestBody CreateProductRequestDTO dto)
    {
        Product product = productService.updateProductById(id,
                dto.getTitle(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getImage(),
                dto.getCategory());

        return product.convertToResponseDTO();
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable("id") Integer id){
        return productService.deleteProduct(id);
    }

    @DeleteMapping("products/exchange/{id}")
    public ProductResponseDTO deleteProductById(@PathVariable("id") Integer id){
        Product product = productService.deleteProductById(id);
        return product.convertToResponseDTO();
    }

}
