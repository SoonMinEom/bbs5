package com.mustache.bbs5.service;

import com.mustache.bbs5.domain.dto.HospitalResponse;
import com.mustache.bbs5.domain.entity.Hospital;
import com.mustache.bbs5.repository.HospitalRepository;
import net.bytebuddy.dynamic.DynamicType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class HospitalServiceTest {

    private HospitalRepository hospitalRepository= Mockito.mock(HospitalRepository.class);

    private HospitalService hospitalService;

    @BeforeEach
    void setUp() {
        hospitalService = new HospitalService(hospitalRepository);
    }

    @Test
    void serviceTest() {

        Hospital hospital1 = new Hospital(1,"병원이름","병원주소",13);

        Mockito.when(hospitalRepository.findById(1))
                .thenReturn(Optional.of(hospital1));

        HospitalResponse hospitalResponse = hospitalService.getHospital(1);
        assertEquals("영업중",hospitalResponse.getBusinessStatusName());

        Hospital hospital2 = new Hospital(2,"병원이름","병원주소",3);

        Mockito.when(hospitalRepository.findById(2))
                .thenReturn(Optional.of(hospital2));

        HospitalResponse hospitalResponse2 = hospitalService.getHospital(2);
        assertEquals("폐업",hospitalResponse2.getBusinessStatusName());
    }
}