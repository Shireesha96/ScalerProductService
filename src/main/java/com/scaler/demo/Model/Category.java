package com.scaler.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.scaler.demo.dto.CategoryResponseDTO;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
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

     @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY) // we give mapped by to avoid duplicate relations
     //else it creates separate mapping table for category product combination
     // as we have already specified cardinality in Product class
     @JsonIgnore
     private List<Product> products;

     public CategoryResponseDTO convertToResponseDTO() {
          CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
          categoryResponseDTO.setId(getId());
          categoryResponseDTO.setName(name);
          return categoryResponseDTO;
     }
}