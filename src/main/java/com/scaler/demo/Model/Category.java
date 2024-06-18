package com.scaler.demo.Model;

import com.scaler.demo.dto.CategoryResponseDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Category  extends BaseModel{
     private String name;

     @OneToMany(mappedBy = "category") // we give mapped by to avoid duplicate relations
     //else it creates separate mapping table for category product combination
     // as we have already specified cardinality in Product class
     private List<Product> products;

     public CategoryResponseDTO convertToResponseDTO() {
          CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
          //categoryResponseDTO.setId(id);
          categoryResponseDTO.setName(name);
          return categoryResponseDTO;
     }
}