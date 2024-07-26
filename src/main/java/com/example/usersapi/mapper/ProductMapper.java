package com.example.usersapi.mapper;


import com.example.usersapi.dto.ProductDto;
import com.example.usersapi.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductDto toDto(Product product);

    Product toProduct (ProductDto productDto);

    List<ProductDto> toDtoList(List<Product> productList);

}
