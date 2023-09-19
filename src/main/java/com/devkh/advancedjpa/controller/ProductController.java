package com.devkh.advancedjpa.controller;

import com.devkh.advancedjpa.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public CollectionModel<?> findProducts() {
        return productService.findProducts();
    }

    @GetMapping("/{uuid}")
    public EntityModel<?> findProductByuuid(@PathVariable String uuid) {
        return productService.findProductByUuid(uuid);
    }

}
