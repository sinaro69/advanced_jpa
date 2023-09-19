package com.devkh.advancedjpa.repository;

import com.devkh.advancedjpa.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {
}
