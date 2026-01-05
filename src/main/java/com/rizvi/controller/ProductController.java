package com.rizvi.controller;

import com.rizvi.model.Product;
import com.rizvi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService prodService;

      @GetMapping("/products")
      public List<Product> getProduct(){
             return prodService.getAllProducts();
      }

      @GetMapping("/products/{prodId}")
        public Product getProductById(@PathVariable int prodId) {
          return prodService.getProductById(prodId);
      }

      @PostMapping("/products")
        public void addProduct(@RequestBody Product prod) {
          System.out.println("Adding new product: " + prod);
            prodService.addProduct(prod);
        }

        @PutMapping("/products")
        public void updateProduct(@RequestBody Product prod) {
          System.out.println("Updating product: " + prod);
          prodService.updateProduct(prod);
        }

        @DeleteMapping("/products/{prodId}")
        public void deleteProduct(@PathVariable int prodId) {
            System.out.println("Deleting product with ID: " + prodId);
            prodService.deleteProduct(prodId);
        }

}
