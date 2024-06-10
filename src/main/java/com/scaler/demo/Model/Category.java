package com.scaler.demo.Model;

import com.scaler.demo.dto.CategoryResponseDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Category  extends BaseModel{
     private String name;

     public CategoryResponseDTO convertToResponseDTO() {
          CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
          //categoryResponseDTO.setId(id);
          categoryResponseDTO.setName(name);
          return categoryResponseDTO;
     }
}