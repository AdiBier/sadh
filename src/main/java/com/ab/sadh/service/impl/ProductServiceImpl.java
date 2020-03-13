package com.ab.sadh.service.impl;

import com.ab.sadh.model.Product;
import com.ab.sadh.repository.ProductsRepository;
import com.ab.sadh.service.ProductService;
<<<<<<< HEAD
=======
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> c4b6c9a2f9b76a194a3e0f08791818bb414f9e09
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductsRepository productsRepository;

<<<<<<< HEAD
=======
    @Autowired
>>>>>>> c4b6c9a2f9b76a194a3e0f08791818bb414f9e09
    public ProductServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public void addProduct(Product product) {
        productsRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productsRepository.delete(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return StreamSupport.stream(productsRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
}
