package com.mustache.bbs5.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HospitalResponse {
    private Integer id;
    private String hospitalName;
    private String roadNameAddress;
    private String businessTypeName;
    private Integer patientRoomCount;
    private Integer totalNumberOfBeds;
    private Float totalAreaSize;

    public HospitalResponse(Integer id, String hospitalName, String roadNameAddress) {
        this.id = id;
        this.hospitalName = hospitalName;
        this.roadNameAddress = roadNameAddress;
    }
}
