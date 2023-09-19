package com.devkh.advancedjpa.repository;

import com.devkh.advancedjpa.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByNameContainingIgnoreCase(String name);

    List<Category> findByIdOrName(Long id, String name);

    List<Category> findByName(String name);
}
