package com.mustache.bbs5.repository;

import com.mustache.bbs5.domain.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepositoty extends JpaRepository<Hospital, Integer> {
}
