package com.mustache.bbs5.repository;

import com.mustache.bbs5.domain.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

    List<Hospital> findByBusinessTypeNameIn(List<String> businessTypes);
    List<Hospital> findByRoadNameAddressContaining(String keyword);
    List<Hospital> findByRoadNameAddressStartsWith(String keyword);
    List<Hospital> findByHospitalNameEndsWith(String keyword);

    List<Hospital> findByPatientRoomCountBetween(Integer start, Integer end);
}
