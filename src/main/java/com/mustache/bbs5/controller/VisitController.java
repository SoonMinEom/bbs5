package com.mustache.bbs5.controller;

import com.mustache.bbs5.domain.dto.VisitRequest;
import com.mustache.bbs5.domain.dto.VisitResponse;
import com.mustache.bbs5.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/visits")
@RequiredArgsConstructor
public class VisitController {

    private final VisitService visitService;

    @PostMapping("/login")
    public ResponseEntity<String> login () {
        String token = visitService.login();
        return ResponseEntity.ok().body(token);
    }

    @PostMapping
    public ResponseEntity<VisitResponse> create(@RequestBody VisitRequest visitRequest, Authentication authentication) {
        VisitResponse visitResponse = visitService.create(visitRequest, authentication.getName());
        return ResponseEntity.ok().body(visitResponse);
    }

    @GetMapping
    public ResponseEntity<List<VisitResponse>> seeAll(Authentication authentication) {
        List<VisitResponse> list = visitService.seeAll(authentication.getName());
        return ResponseEntity.ok().body(list);
    }
}
