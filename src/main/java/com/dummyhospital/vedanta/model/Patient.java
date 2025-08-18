package com.dummyhospital.vedanta.model;


import com.dummyhospital.vedanta.enums.PatientSymptom;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    private Long id;

    private String name;
    private String city;
    private String email;
    private String phone;
    private PatientSymptom symptom;
}
