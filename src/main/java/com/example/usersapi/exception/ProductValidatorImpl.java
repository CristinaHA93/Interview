package com.example.usersapi.exception;

import com.example.usersapi.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductValidatorImpl implements ProductValidate{

    @Override
    public void validate(Product product) {
        List<String> errorMessage = new ArrayList<>();

        if(!StringUtils.hasLength(product.getName())){
            errorMessage.add("The name can't be empty");
        }

        if(!errorMessage.isEmpty()){
            StringBuilder message = new StringBuilder();
            for(String item : errorMessage){
                message.append(item).append("/n");
            }
            throw  new ProductInvalidDataException(message.toString());
        }
    }

}
