package com.mustache.bbs5.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class VisitResponse {
    private String userName;
    private String hospitalName;
    private String disease;
    private int cost;
}
