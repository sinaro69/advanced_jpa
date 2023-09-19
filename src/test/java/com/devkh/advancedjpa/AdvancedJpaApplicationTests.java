package com.devkh.advancedjpa;

import com.devkh.advancedjpa.entity.Category;
import com.devkh.advancedjpa.entity.Product;
import com.devkh.advancedjpa.repository.CategoryRepository;
import com.devkh.advancedjpa.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class AdvancedJpaApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void testUpdateProductName() {
        String newName = "Dell Desktop";
        System.out.println(productRepository.updateProductNameById(5L, newName));
    }

    @Test
    void testFindCategoryByName() {
        List<Category> categories = categoryRepository.findByName("Electronic");
        categories.forEach(category -> System.out.println(category.getName()));
    }

    @Test
    void testFindCategoryByIdOrName() {
        List<Category> categories = categoryRepository.findByIdOrName(1L, "Electronic");
        categories.forEach(category -> System.out.println(category.getName()));
    }

    @Test
    void testFindCategoryByNameContains() {
        List<Category> categories =
                categoryRepository.findByNameContainingIgnoreCase("Nic");
        categories.forEach(category -> System.out.println(category.getName()));
    }

    @Test
    void testFindProducts() {
        //Product product = productRepository.report("dc2ec5bf-17ea-49c3-977a-f0b7b6ea6687","macBook Pro M1");
        //System.out.println(product.getName());
        List<Product> products = productRepository.report();
        products.forEach(product -> System.out.println(product.getName()));
    }

}
