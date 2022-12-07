package com.mustache.bbs5.service;

import com.mustache.bbs5.domain.dto.ArticleResponse;
import com.mustache.bbs5.domain.dto.HospitalResponse;
import com.mustache.bbs5.domain.entity.Hospital;
import com.mustache.bbs5.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @Transactional
    public Page<Hospital> getHospitalList(Pageable pageable) {
        return hospitalRepository.findAll(pageable);
    }

    @Transactional
    public Page<Hospital> getHospitalListWithRoadName(String keyword, Pageable pageable) {
        return hospitalRepository.findByRoadNameAddressContaining(keyword, pageable);
    }

    public HospitalResponse getHospital(Integer id) {
        Optional<Hospital> opthospital = hospitalRepository.findById(id);
        Hospital hospital = opthospital.get();
        HospitalResponse hospitalResponse = Hospital.of(hospital);

//        switch (hospital.getBusinessStatusCode()) {
//            case 13:hospitalResponse.setBusinessStatusName("영업중"); break;
//            case 3:hospitalResponse.setBusinessStatusName("폐업"); break;
//            case 4:hospitalResponse.setBusinessStatusName(""); break;
//            case 24:hospitalResponse.setBusinessStatusName(""); break;
//        }
        if(hospital.getBusinessStatusCode() == 13) {
            hospitalResponse.setBusinessStatusName("영업중");
        } else if(hospital.getBusinessStatusCode() == 3) {
            hospitalResponse.setBusinessStatusName("폐업");
        } else {
            hospitalResponse.setBusinessStatusName(String.valueOf(hospital.getBusinessStatusCode()));
        }

        return  hospitalResponse;
    }
}
