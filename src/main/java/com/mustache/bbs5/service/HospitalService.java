package com.mustache.bbs5.service;

import com.mustache.bbs5.domain.entity.Hospital;
import com.mustache.bbs5.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HospitalService {

    @Autowired
    HospitalRepository hospitalRepository;

    @Transactional
    public Page<Hospital> getHospitalList(Pageable pageable) {
        return hospitalRepository.findAll(pageable);
    }
}
