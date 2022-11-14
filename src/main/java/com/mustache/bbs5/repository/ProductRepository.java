package com.mustache.bbs5.repository;

import com.mustache.bbs5.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
