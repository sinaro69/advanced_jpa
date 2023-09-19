package com.devkh.advancedjpa.init;

import com.devkh.advancedjpa.entity.Category;
import com.devkh.advancedjpa.entity.Price;
import com.devkh.advancedjpa.entity.Product;
import com.devkh.advancedjpa.repository.CategoryRepository;
import com.devkh.advancedjpa.repository.PriceRepository;
import com.devkh.advancedjpa.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInitialization {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final PriceRepository priceRepository;

    //@PostConstruct
    void init() {

        System.out.println("Start initialize data...");

        Category electronic = Category.builder().name("Electronic").build();
        Category smartphone = Category.builder().name("Smart Phone").build();
        Category sonic = Category.builder().name("Sonic").build();
        categoryRepository.saveAll(List.of(electronic, smartphone, sonic));

        Price defaultPrice = Price.builder()
                .priceIn(BigDecimal.valueOf(1000))
                .priceOut(BigDecimal.valueOf(1500))
                .build();
        Price specialPrice = Price.builder()
                .priceIn(BigDecimal.valueOf(1000))
                .priceOut(BigDecimal.valueOf(800))
                .build();

        priceRepository.saveAll(List.of(defaultPrice, specialPrice));

        Product product1 = Product.builder()
                .uuid(UUID.randomUUID().toString())
                .name("iPhone 13 Pro Max")
                .description("Apple Inc.")
                .category(smartphone)
                .prices(List.of(defaultPrice, specialPrice))
                .build();
        Product product2 = Product.builder()
                .uuid(UUID.randomUUID().toString())
                .name("macBook Pro M1")
                .description("Apple Inc.")
                .category(electronic)
                .prices(List.of(defaultPrice, specialPrice))
                .build();
        Product product3 = Product.builder()
                .uuid(UUID.randomUUID().toString())
                .name("macBook Pro M2")
                .description("Apple Inc.")
                .category(electronic)
                .prices(List.of(defaultPrice, specialPrice))
                .build();

        /*productRepository.save(product1);
        productRepository.save(product2);*/

        productRepository.saveAll(List.of(product1, product2, product3));

        List<Product> products = productRepository.findAll();
        products.forEach(product -> System.out.println(product.getName()));
    }

}
