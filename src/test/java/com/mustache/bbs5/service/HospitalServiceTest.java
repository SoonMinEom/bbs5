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
        Mockito.when(hospitalRepository.findById(1))
                .thenReturn(Optional.of(new Hospital(1,"병원이름","병원주소",13)));

        HospitalResponse hospitalResponse = hospitalService.getHospital(1);
        assertEquals("영업중",hospitalResponse.getBusinessStatusName());
    }
}