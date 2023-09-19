package com.devkh.advancedjpa.repository;

import com.devkh.advancedjpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE pro AS pro SET pro.name = :name WHERE pro.id = :id")
    int updateProductNameById(Long id, String name);

    @Query("SELECT p FROM pro AS p WHERE p.uuid = :uuid AND p.name = :name order by p.name desc")
    Product report(String uuid, String name);

    @Query("SELECT p FROM pro AS p ORDER BY p.id DESC")
    List<Product> report();

    Optional<Product> findByUuid(String uuid);

}
