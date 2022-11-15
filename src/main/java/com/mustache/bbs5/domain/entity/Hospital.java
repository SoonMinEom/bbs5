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
    private String hospitalName;
    private String roadNameAddress;
    private String businessTypeName;
    private Integer patientRoomCount;

    public static HospitalResponse of(Hospital hospital) {
        return  new HospitalResponse(hospital.getId(), hospital.getHospitalName(), hospital.getRoadNameAddress());
    }
}
