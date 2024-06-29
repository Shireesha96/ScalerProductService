package com.scaler.demo.controller;

import com.scaler.demo.Model.Category;
import com.scaler.demo.Model.Product;
import com.scaler.demo.dto.CategoryResponseDTO;
import com.scaler.demo.dto.CreateProductRequestDTO;
import com.scaler.demo.dto.ProductResponseDTO;
import com.scaler.demo.exception.CategoryNotFoundException;
import com.scaler.demo.service.FakeStoreService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
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
    public ProductResponseDTO addProduct(@RequestBody CreateProductRequestDTO dto) throws CategoryNotFoundException {
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

    @PostMapping("category/{name}")
    public CategoryResponseDTO addCategory(@PathVariable("name") String name){
        CategoryResponseDTO categoryResponseDTO = productService.addCategory(name).convertToResponseDTO();
        return categoryResponseDTO;
    }

    @DeleteMapping("category/{name}")
    public String deleteCategory(@PathVariable("name") String name){
        return productService.deleteCategory(name);
    }

    @GetMapping("products/{pageNo}/{pageSize}")

    public List<ProductResponseDTO> getPaginatedProducts(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize){
        List<Product> products = productService.getPaginatedProducts(pageNo, pageSize);
        List<ProductResponseDTO> responseDTOList = new ArrayList<>();
        for(Product p : products){
            responseDTOList.add(p.convertToResponseDTO());
        }
        return responseDTOList;
    }

}
