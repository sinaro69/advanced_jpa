package com.devkh.advancedjpa.assember;

import com.devkh.advancedjpa.controller.ProductController;
import com.devkh.advancedjpa.dto.ProductDto;
import com.devkh.advancedjpa.entity.Product;
import com.devkh.advancedjpa.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.stereotype.Component;

@Component
public class ProductModelAssembler extends RepresentationModelAssemblerSupport<Product, EntityModel<ProductDto>> {

    private ProductMapper productMapper;

    @Autowired
    public void setProductMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @SuppressWarnings("unchecked")
    public ProductModelAssembler() {
        super(ProductController.class, (Class<EntityModel<ProductDto>>) (Class<?>) EntityModel.class);
    }

    @Override
    public EntityModel<ProductDto> toModel(Product entity) {
        ProductDto productDto = productMapper.mapProductToProductDto(entity);
        Link selfLink = linkTo(methodOn(ProductController.class).findProductByuuid(entity.getUuid())).withSelfRel();
        Link collectionLink = linkTo(methodOn(ProductController.class).findProducts()).withRel(IanaLinkRelations.COLLECTION);
        return EntityModel.of(productDto, selfLink, collectionLink);
    }

    @Override
    public CollectionModel<EntityModel<ProductDto>> toCollectionModel(Iterable<? extends Product> entities) {
        return super.toCollectionModel(entities);
    }
}
