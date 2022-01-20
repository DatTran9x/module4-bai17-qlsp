package com.qlsp.service;

import com.qlsp.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    void delete(int id);
    Product findById(int id);
}
