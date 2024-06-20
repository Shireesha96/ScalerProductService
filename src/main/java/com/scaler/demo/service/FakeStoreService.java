package com.scaler.demo.service;

import com.scaler.demo.Model.Category;
import com.scaler.demo.Model.Product;
import com.scaler.demo.dto.FakeStoreProductDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreService")
public class FakeStoreService implements ProductService{
    private RestTemplate restTemplate;

    public FakeStoreService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Integer id){
        ResponseEntity<FakeStoreProductDTO> dto = restTemplate.getForEntity("https://fakestoreapi.com/products/"+id, FakeStoreProductDTO.class);
        FakeStoreProductDTO fakeStoreProductDTO = dto.getBody();
        //System.out.println(fakeStoreProductDTO.getId());
        return fakeStoreProductDTO.ConverToProduct();
    }

    @Override
    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();
        FakeStoreProductDTO[] dtos = restTemplate.getForObject("https://fakestoreapi.com/products",FakeStoreProductDTO[].class);
        for(FakeStoreProductDTO dto : dtos){
            products.add(dto.ConverToProduct());
        }
        return  products;
    }

    @Override
    public List<Category> getAllCategories(){
        List<Category> categories = new ArrayList<>();
        ResponseEntity<String[]> dtos = restTemplate.getForEntity("https://fakestoreapi.com/products/categories", String[].class);
        //system.out.println(dtos[0]);
        for(String dto : dtos.getBody()){
            Category c = new Category();
            c.setName(dto);
            categories.add(c);
        }
        return categories;
    }

    @Override
    public List<Product> getProductByCategory(String category)
    {
        List<Product> products = new ArrayList<>();
        ResponseEntity<FakeStoreProductDTO[]> dtos = restTemplate.getForEntity("https://fakestoreapi.com/products/category/"+category, FakeStoreProductDTO[].class);
        for(FakeStoreProductDTO dto : dtos.getBody()){
            products.add(dto.ConverToProduct());
        }
        return products;
    }

    @Override
    public Product addProduct(String title, String desc, Double price, String imageUrl, String category) {
        FakeStoreProductDTO requestBody = new FakeStoreProductDTO();
        requestBody.setTitle(title);
        requestBody.setDescription(desc);
        requestBody.setPrice(String.valueOf(price));
        requestBody.setImage(imageUrl);
        requestBody.setCategory(category);

        ResponseEntity<FakeStoreProductDTO> dto = restTemplate.postForEntity("https://fakestoreapi.com/products", requestBody, FakeStoreProductDTO.class);
        FakeStoreProductDTO response = dto.getBody();
        return response.ConverToProduct();
    }

    @Override
    public Product updateProduct(Integer id, String title, String desc, Double price, String imageUrl, String category){
        FakeStoreProductDTO requestBody = new FakeStoreProductDTO();
        requestBody.setTitle(title);
        requestBody.setDescription(desc);
        requestBody.setPrice(String.valueOf(price));
        requestBody.setImage(imageUrl);
        requestBody.setCategory(category);

        FakeStoreProductDTO responseDTO = restTemplate.patchForObject("https://fakestoreapi.com/products/" + id, requestBody, FakeStoreProductDTO.class);
        return responseDTO.ConverToProduct();
    }

    @Override
    public Product updateProductById(Integer id, String title, String desc, Double price, String imageUrl, String category) {
        FakeStoreProductDTO requestBody = new FakeStoreProductDTO();
        requestBody.setTitle(title);
        requestBody.setDescription(desc);
        requestBody.setPrice(String.valueOf(price));
        requestBody.setImage(imageUrl);
        requestBody.setCategory(category);
        //HttpHeaders headers = new HttpHeaders();
        HttpEntity<FakeStoreProductDTO> entity = new HttpEntity<>(requestBody);
        ResponseEntity<FakeStoreProductDTO> dto = restTemplate.exchange("https://fakestoreapi.com/products/" + id, HttpMethod.PUT, entity, FakeStoreProductDTO.class);
        return dto.getBody().ConverToProduct();
    }

    @Override
    public String deleteProduct(Integer id) {

        restTemplate.delete("https://fakestoreapi.com/products/"+id);
        return "Success";
    }

    @Override
    public Product deleteProductById(Integer id) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<FakeStoreProductDTO> dto =   restTemplate.exchange("https://fakestoreapi.com/products/"+id, HttpMethod.DELETE, entity, FakeStoreProductDTO.class);
        return dto.getBody().ConverToProduct();
    }

    @Override
    public Category addCategory(String category) {
        return null;
    }

    @Override
    public String deleteCategory(String category) {
        return "";
    }

}
