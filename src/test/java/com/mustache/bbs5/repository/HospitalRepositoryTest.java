package com.mustache.bbs5.repository;

import com.mustache.bbs5.domain.entity.Hospital;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HospitalRepositoryTest {

    @Autowired
    HospitalRepository hospitalRepository;

    @Test
    void find() {
        List<String> inClues = new ArrayList<>();
        inClues.add("보건소");
        inClues.add("보건지소");
        inClues.add("보건진료소");

        List<Hospital> hospitalList = hospitalRepository.findByBusinessTypeNameIn(inClues);
        for (Hospital hospital : hospitalList) {
            System.out.println(hospital.getHospital_name());
        }

    }

}