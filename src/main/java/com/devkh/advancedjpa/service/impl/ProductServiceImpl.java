package com.devkh.advancedjpa.service.impl;

import com.devkh.advancedjpa.assember.ProductModelAssembler;
import com.devkh.advancedjpa.entity.Product;
import com.devkh.advancedjpa.repository.ProductRepository;
import com.devkh.advancedjpa.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductModelAssembler productModelAssembler;

    @Override
    public CollectionModel<?> findProducts() {

        List<Product> products = productRepository.findAll();

        return productModelAssembler.toCollectionModel(products);
    }

    @Override
    public EntityModel<?> findProductByUuid(String uuid) {
        Product product = productRepository.findByUuid(uuid).orElseThrow();
        return productModelAssembler.toModel(product);
    }
}
