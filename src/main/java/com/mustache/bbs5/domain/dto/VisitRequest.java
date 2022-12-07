package com.mustache.bbs5.domain.dto;

import com.mustache.bbs5.domain.entity.Hospital;
import com.mustache.bbs5.domain.entity.User;
import com.mustache.bbs5.domain.entity.Visit;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class VisitRequest {
    private int hospitalId;
    private String disease;
    private int cost;

    public Visit toEntity(User user, Hospital hospital){
        return Visit.builder()
                .userId(user)
                .hospitalId(hospital)
                .disease(this.disease)
                .cost(this.cost)
                .build();
    }
}
