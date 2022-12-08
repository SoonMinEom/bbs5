package com.mustache.bbs5.domain.entity;

import com.mustache.bbs5.domain.dto.VisitRequest;
import com.mustache.bbs5.domain.dto.VisitResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Visit extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospitalId;
    private String disease;
    private int cost;

    public VisitResponse toResponse(String username, String hospitalName) {
        return VisitResponse.builder()
                .userName(username)
                .hospitalName(hospitalName)
                .disease(this.disease)
                .cost(this.cost)
                .build();
    }
}
