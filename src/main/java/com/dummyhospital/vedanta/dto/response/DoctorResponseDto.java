package com.dummyhospital.vedanta.dto.response;

import com.dummyhospital.vedanta.enums.DoctorCity;
import com.dummyhospital.vedanta.enums.DoctorSpeciality;
import lombok.Data;

@Data
public class DoctorResponseDto {
    private Long id;
    private String name;
    private DoctorCity city;
    private String email;
    private String phone;
    private DoctorSpeciality speciality;
}
