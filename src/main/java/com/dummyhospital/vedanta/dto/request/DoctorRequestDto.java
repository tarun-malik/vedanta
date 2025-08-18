package com.dummyhospital.vedanta.dto.request;

import com.dummyhospital.vedanta.enums.DoctorCity;
import com.dummyhospital.vedanta.enums.DoctorSpeciality;
import lombok.Data;

@Data
public class DoctorRequestDto {
    private String name;
    private DoctorCity city;
    private String email;
    private String phone;
    private DoctorSpeciality speciality;
}
