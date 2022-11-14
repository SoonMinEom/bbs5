package com.mustache.bbs5.repository;

import com.mustache.bbs5.domain.entity.Hospital;
import com.mustache.bbs5.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
