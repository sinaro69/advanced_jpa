package com.devkh.advancedjpa.service;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface ProductService {

    CollectionModel<?> findProducts();

    EntityModel<?> findProductByUuid(String uuid);
}
