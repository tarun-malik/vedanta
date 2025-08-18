package com.dummyhospital.vedanta.service;

import com.dummyhospital.vedanta.dto.request.DoctorRequestDto;
import com.dummyhospital.vedanta.dto.response.DoctorResponseDto;
import com.dummyhospital.vedanta.dto.response.GenericResponseDto;

import java.util.List;

public interface DoctorService {
    //CRUD
    DoctorResponseDto registerDoctor(DoctorRequestDto doctorRequestDto);
    DoctorResponseDto getDoctor(Long id);
    List<DoctorResponseDto> getAllDoctors();
    DoctorResponseDto updateDoctor(Long id, DoctorRequestDto doctorRequestDto);
    GenericResponseDto removeDoctor(Long id);
}
