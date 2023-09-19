package com.devkh.advancedjpa.dto;

import org.springframework.hateoas.server.core.Relation;

@Relation(collectionRelation = "products", itemRelation = "product")
public record ProductDto(String uuid,
                         String name,
                         String description) {
}
