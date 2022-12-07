package com.mustache.bbs5.service;

import com.mustache.bbs5.domain.dto.VisitRequest;
import com.mustache.bbs5.domain.dto.VisitResponse;
import com.mustache.bbs5.domain.entity.Hospital;
import com.mustache.bbs5.domain.entity.User;
import com.mustache.bbs5.domain.entity.Visit;
import com.mustache.bbs5.repository.HospitalRepository;
import com.mustache.bbs5.repository.UserRepository;
import com.mustache.bbs5.repository.VisitRepository;
import com.mustache.bbs5.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final HospitalRepository hospitalRepository;
    private final UserRepository userRepository;
    private final VisitRepository visitRepository;

    @Value("${jwt.token.secret}")
    private String secretKey;

    public String login() {
        return JwtUtil.createToken(secretKey);
    }

    public VisitResponse create(VisitRequest visitRequest, String userName) {
        User user = userRepository.findByUsername(userName);
        Optional<Hospital> hospital = hospitalRepository.findById(visitRequest.getHospitalId());
        Visit visit =visitRepository.save(visitRequest.toEntity(user, hospital.get()));
        VisitResponse visitResponse = visit.toResponse(userName, hospital.get().getHospitalName());
        return visitResponse;
    }

}
