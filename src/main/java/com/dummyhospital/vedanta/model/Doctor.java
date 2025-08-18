package com.dummyhospital.vedanta.model;


import com.dummyhospital.vedanta.enums.DoctorCity;
import com.dummyhospital.vedanta.enums.DoctorSpeciality;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private DoctorCity city;

    private String email;
    private String phone;

    @Enumerated(EnumType.STRING)
    private DoctorSpeciality speciality;
}
