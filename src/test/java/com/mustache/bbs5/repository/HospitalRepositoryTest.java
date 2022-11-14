package com.mustache.bbs5.repository;

import com.mustache.bbs5.domain.entity.Hospital;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("여러개의 In조건")
    void find() {
        List<String> inClues = new ArrayList<>();
        inClues.add("보건소");
        inClues.add("보건지소");
        inClues.add("보건진료소");

        List<Hospital> hospitalList = hospitalRepository.findByBusinessTypeNameIn(inClues);
        for (Hospital hospital : hospitalList) {
            System.out.println(hospital.getHospitalName());
        }
    }

    @Test
    @DisplayName("Containing 사용")
    void find2() {
        List<Hospital> hospitals = hospitalRepository.findByRoadNameAddressContaining("송파구");
        for (Hospital hospital : hospitals) {
            System.out.println(hospital.getRoadNameAddress());
        }
    }

    @Test
    @DisplayName("StartsWith 사용")
    void find3() {
        List<Hospital> hospitals = hospitalRepository.findByRoadNameAddressStartsWith("경기도");
        for (Hospital hospital : hospitals) {
            System.out.println(hospital.getRoadNameAddress());
        }
    }
    @Test
    @DisplayName("EndsWith 사용")
    void find4() {
        List<Hospital> hospitals = hospitalRepository.findByHospitalNameEndsWith("의원");
        for (Hospital hospital : hospitals) {
            System.out.println(hospital.getHospitalName());
        }
    }

    @Test
    @DisplayName("Between 사용")
    void find5() {
        List<Hospital> hospitals = hospitalRepository.findByPatientRoomCountBetweenOrderByPatientRoomCountAsc(10,20);
        for (Hospital hospital : hospitals) {
            System.out.printf("%s, %d\n",hospital.getHospitalName(), hospital.getPatientRoomCount());
        }
    }
}