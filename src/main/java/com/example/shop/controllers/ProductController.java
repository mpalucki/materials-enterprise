package com.example.shop.controllers;


import com.example.shop.DTO.ProductDTO;
import com.example.shop.model.Product;
import com.example.shop.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;


@RestController
public class ProductController {

    @Autowired
    ProductsRepository productsRepository;

    @RequestMapping(value = "products", method = RequestMethod.GET)
    public List<ProductDTO> getAllProducts (){
        List<Product> products = productsRepository.findAll();
        return mapProductList(products);
    }

    @RequestMapping(value = "products/new", method = RequestMethod.POST)
    public void addProduct (@RequestParam(name = "name") String name,
                            @RequestParam(name = "description") String description,
                            @RequestParam(name = "price") float price,
                            HttpServletResponse httpServletResponse){
        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setDescription(description);
        newProduct.setPrice(price);
        productsRepository.save(newProduct);
        
        httpServletResponse.setHeader("Location", "/");
        httpServletResponse.setStatus(302);
    }



    private List<ProductDTO> mapProductList(List<Product> products){
        List<ProductDTO> productDTOS = new LinkedList<>();
        for(Product product : products){
            productDTOS.add(new ProductDTO().toDTO(product));
        }
        return productDTOS;
    }

}
