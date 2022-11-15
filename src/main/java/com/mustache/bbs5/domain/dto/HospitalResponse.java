package com.mustache.bbs5.domain.dto;

import lombok.Getter;

@Getter

public class HospitalResponse {
    private Integer id;
    private String hospitalName;
    private String roadNameAddress;
    private String businessTypeName;
    private Integer patientRoomCount;

    public HospitalResponse(Integer id, String hospitalName, String roadNameAddress) {
        this.id = id;
        this.hospitalName = hospitalName;
        this.roadNameAddress = roadNameAddress;
    }
}
