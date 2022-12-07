package com.mustache.bbs5.repository;

import com.mustache.bbs5.domain.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}
