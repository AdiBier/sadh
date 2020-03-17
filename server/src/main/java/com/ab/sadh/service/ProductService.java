package com.ab.sadh.service;

import com.ab.sadh.model.Product;

import java.util.List;

public interface ProductService {

    void addProduct(Product product);

    void deleteProduct(Product product);

    List<Product> getAllProducts();
}
