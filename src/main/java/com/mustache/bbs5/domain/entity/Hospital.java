package com.mustache.bbs5.domain.entity;

import com.mustache.bbs5.domain.dto.HospitalResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table( name = "nation_wide_hospitals")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String roadNameAddress;
    private String hospitalName;
    private Integer patientRoomCount;
    private Integer totalNumberOfBeds;
    private String businessTypeName;
    private Integer businessStatusCode;
    private Float totalAreaSize;

    public Hospital(Integer id, String roadNameAddress, String hospitalName, Integer businessStatusCode) {
        this.id = id;
        this.roadNameAddress = roadNameAddress;
        this.hospitalName = hospitalName;
        this.businessStatusCode = businessStatusCode;
    }

    public static HospitalResponse of(Hospital hospital) {
        return  new HospitalResponse(hospital.getId(),
                hospital.getRoadNameAddress(),
                hospital.getHospitalName(),
                hospital.getPatientRoomCount(),
                hospital.getTotalNumberOfBeds(),
                hospital.getBusinessTypeName(),
                hospital.getTotalAreaSize());
    }
}
