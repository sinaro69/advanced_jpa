package com.devkh.advancedjpa.mapper;

import com.devkh.advancedjpa.dto.ProductDto;
import com.devkh.advancedjpa.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto mapProductToProductDto(Product product);

    List<ProductDto> mapProductsToProductDtoList(List<Product> products);

}
