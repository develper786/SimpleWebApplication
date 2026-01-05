package com.rizvi.service;

import com.rizvi.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class ProductService {

    List<Product> products = new ArrayList<>(Arrays.asList(new Product(101, "Laptop", 1000),
                                           new Product(102, "Iphone", 1200),
                                           new Product(103, "Tablet", 800)));

       public List<Product> getAllProducts(){
           return products;
       }

       public Product getProductById(int prodId){
           return products.stream()
                   .filter(prod -> prod.getProdId() == prodId)
                   .findFirst()
                   .orElse(new Product(100, "Not Found", 0));
       }

    public void addProduct(Product prod) {
        products.add(prod);
    }


    public void updateProduct(Product prod  ) {
         int index = 0;
        for (int i = 0; i < products.size(); i++) {
//            Product p = products.get(i);
//            if (p.getProdId() == prod.getProdId()) {
//                products.set(i, prod);
//                return;
            if (products.get(i).getProdId() == prod.getProdId()) {
                index = i;
                products.set(index, prod);
                return;
            }
        }
    }

    public void deleteProduct(int prodId) {
        products.removeIf(prod -> prod.getProdId() == prodId);

    }
}
