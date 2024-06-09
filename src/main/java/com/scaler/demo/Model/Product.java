package com.scaler.demo.Model;

import com.scaler.demo.dto.ProductResponseDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Product extends BaseModel {

    private String title;
    private String description;
    private String price;
    private String imageURL;

    @ManyToOne
    private Category category;

    public ProductResponseDTO convertToResponseDTO() {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setId(this.getId());
        productResponseDTO.setTitle(title);
        productResponseDTO.setDescription(description);
        productResponseDTO.setPrice(price);
        productResponseDTO.setImageURL(imageURL);
        productResponseDTO.setCategory(category);
        return  productResponseDTO;
    }

}
