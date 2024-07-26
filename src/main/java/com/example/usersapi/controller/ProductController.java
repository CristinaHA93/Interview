package com.example.usersapi.controller;

import com.example.usersapi.dto.ProductDto;
import com.example.usersapi.mapper.ProductMapper;
import com.example.usersapi.model.Product;
import com.example.usersapi.service.ProductService;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private final ProductService productService;

    @Autowired
    private final ProductMapper productMapper;


    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto){
        Product productRequest = productMapper.toProduct(productDto);
        Product newProduct = productService.create(productRequest);
        return new ResponseEntity<>(productMapper.toDto(newProduct), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable Integer id){
        Product product = productService.getById(id);
        return new ResponseEntity<>(productMapper.toDto(product), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll(){
        List<Product> product = productService.getAll();
        return new ResponseEntity<>(productMapper.toDtoList(product), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductDto> update(@PathVariable Integer id, @Valid @RequestBody ProductDto productDto){
        Product product = productMapper.toProduct(productDto);
        Product productUpdate = productService.update(id,product);
        return new ResponseEntity<>(productMapper.toDto(productUpdate), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductDto> delete(@PathVariable Integer id){
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
