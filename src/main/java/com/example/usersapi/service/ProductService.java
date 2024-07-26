package com.example.usersapi.service;

import com.example.usersapi.model.Product;
import java.util.List;

public interface ProductService {

    Product create(Product product);

    Product getById(Integer id);

    List<Product> getAll();

    Product update(Integer id, Product product);

    void delete(Integer id);

}
