package com.example.shop.DTO;


import com.example.shop.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private String name;

    private String description;

    private float price;

    public ProductDTO toDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setDescription(product.getDescription());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }
}
