package com.example.usersapi.service;

import com.example.usersapi.exception.NoFoundException;
import com.example.usersapi.exception.ProductValidate;
import com.example.usersapi.model.Product;
import com.example.usersapi.repository.ProductRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @NonNull
    private final ProductValidate productValidate;

    @NonNull
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductValidate productValidate, ProductRepository productRepository) {
        this.productValidate = productValidate;
        this.productRepository = productRepository;
    }


    @Override
    public Product create(Product product) {
        this.productValidate.validate(product);
        return productRepository.save(product);
    }

    @Override
    public Product getById(Integer id) {
        return productRepository.findById(id).orElseThrow(()->new NoFoundException(id));
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product update(Integer id, Product product) {
        Product findProduct = getById(id);
        findProduct.setPrice(product.getPrice());
        return productRepository.save(findProduct);
    }


    @Override
    public void delete(Integer id) {
        try{
            productRepository.deleteById(id);
        }catch (EmptyResultDataAccessException exception){
            throw  new NoFoundException(id);
        }
    }

}
