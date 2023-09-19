package com.devkh.advancedjpa.mapper;

import com.devkh.advancedjpa.dto.ProductDto;
import com.devkh.advancedjpa.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-19T10:20:23+0700",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 19.0.2 (Amazon.com Inc.)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto mapProductToProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        String uuid = null;
        String name = null;
        String description = null;

        uuid = product.getUuid();
        name = product.getName();
        description = product.getDescription();

        ProductDto productDto = new ProductDto( uuid, name, description );

        return productDto;
    }

    @Override
    public List<ProductDto> mapProductsToProductDtoList(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( products.size() );
        for ( Product product : products ) {
            list.add( mapProductToProductDto( product ) );
        }

        return list;
    }
}
