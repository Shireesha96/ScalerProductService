package com.scaler.demo.service;

import com.scaler.demo.Model.Category;
import com.scaler.demo.Model.Product;
import com.scaler.demo.exception.CategoryNotFoundException;
import com.scaler.demo.repository.CategoryRepository;
import com.scaler.demo.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
@Transactional
public class SelfProductService implements ProductService {
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        Category cat = categoryRepository.findByName(category);
        return productRepository.getProductByCategory(cat);
    }

    @Override
    public Product addProduct(String title, String desc, Double price, String imageUrl, String category) throws CategoryNotFoundException {
        Category categoryObj = categoryRepository.findByName(category);
        if(categoryObj == null){
            throw new CategoryNotFoundException("Category not found");
        }

        Product newProduct = new Product();
        newProduct.setTitle(title);
        newProduct.setDescription(desc);
        newProduct.setImageURL(imageUrl);
        newProduct.setPrice(price.toString());
        newProduct.setCategory(categoryObj);


        return productRepository.save(newProduct);

    }

    @Override
    public Product updateProduct(Integer id, String title, String desc, Double price, String imageUrl, String category) {
        Category categoryObj = categoryRepository.findByName(category);
        if(categoryObj == null){
            Category newCategory = new Category();
            newCategory.setName(category);
            categoryObj = categoryRepository.save(newCategory);
        }

        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setDescription(desc);
        product.setImageURL(imageUrl);
        product.setPrice(price.toString());
        product.setCategory(categoryObj);

        return productRepository.save(product);
    }

    @Override //  works when (cascade = CascadeType.REMOVE) removed from Product
    // check how to mention cascade type for entity
    // when category is removed all the products associated to the category should be removed
    public String deleteProduct(Integer id) {
        productRepository.deleteById(id);
        return "Successfully deleted";
    }

    @Override
    public Product updateProductById(Integer id, String title, String desc, Double price, String imageUrl, String category) {
        return null;
    }

    @Override
    public Product deleteProductById(Integer id) {
        return null;
    }

    @Override
    public Category addCategory(String category) {
        Category newCat  = new Category();
        newCat.setName(category);
        return categoryRepository.save(newCat);
    }

    @Override
    public String deleteCategory(String category) {
        categoryRepository.deleteByName(category);
        return "Category deleted";
    }


}
