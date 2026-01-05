package com.rizvi.service;

import com.rizvi.model.Product;
import com.rizvi.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo repo;

//    List<Product> products = new ArrayList<>(Arrays.asList(new Product(101, "Laptop", 1000),
//                                           new Product(102, "Iphone", 1200),
//                                           new Product(103, "Tablet", 800)));

       public List<Product> getAllProducts(){
           return repo.findAll();
       }

       public Product getProductById(int prodId){
           return repo.findById(prodId).orElse(new Product());
       }

    public void addProduct(Product prod) {
        repo.save(prod);
    }


    public void updateProduct(Product prod  ) {
          repo.save(prod);
        }


    public void deleteProduct(int prodId) {

        repo.deleteById(prodId);

    }
}
