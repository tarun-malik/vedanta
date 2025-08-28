package com.dummyhospital.vedanta.service;

import com.dummyhospital.vedanta.dto.request.DoctorRequestDto;
import com.dummyhospital.vedanta.dto.response.DoctorResponseDto;
import com.dummyhospital.vedanta.dto.response.GenericResponseDto;
import com.dummyhospital.vedanta.model.Doctor;
import com.dummyhospital.vedanta.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public DoctorResponseDto registerDoctor(DoctorRequestDto doctorRequestDto) {
        Doctor doctor = new Doctor();

        doctor.setName(doctorRequestDto.getName());
        doctor.setCity(doctorRequestDto.getCity());
        doctor.setEmail(doctorRequestDto.getEmail());
        doctor.setPhone(doctorRequestDto.getPhone());
        doctor.setSpeciality(doctorRequestDto.getSpeciality());

        doctorRepository.save(doctor);

        DoctorResponseDto doctorResponseDto = new DoctorResponseDto();
        doctorResponseDto.setId(doctor.getId());
        doctorResponseDto.setName(doctor.getName());
        doctorResponseDto.setCity(doctor.getCity());
        doctorResponseDto.setEmail(doctor.getEmail());
        doctorResponseDto.setPhone(doctor.getPhone());
        doctorResponseDto.setSpeciality(doctor.getSpeciality());

        return doctorResponseDto;
    }

    @Override
    public DoctorResponseDto getDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElse(null);

        DoctorResponseDto doctorResponseDto = new DoctorResponseDto();
        doctorResponseDto.setId(doctor.getId());
        doctorResponseDto.setName(doctor.getName());
        doctorResponseDto.setCity(doctor.getCity());
        doctorResponseDto.setEmail(doctor.getEmail());
        doctorResponseDto.setPhone(doctor.getPhone());
        doctorResponseDto.setSpeciality(doctor.getSpeciality());

        return doctorResponseDto;
    }

    @Override
    public List<DoctorResponseDto> getAllDoctors() {
        List<Doctor> doctorList = new ArrayList<>(doctorRepository.findAll());

        List<DoctorResponseDto> doctorResponseDtoList = new ArrayList<>();

        for(Doctor doctor : doctorList) {
            DoctorResponseDto doctorResponseDto = new DoctorResponseDto();

            doctorResponseDto.setId(doctor.getId());
            doctorResponseDto.setName(doctor.getName());
            doctorResponseDto.setCity(doctor.getCity());
            doctorResponseDto.setEmail(doctor.getEmail());
            doctorResponseDto.setPhone(doctor.getPhone());
            doctorResponseDto.setSpeciality(doctor.getSpeciality());

            doctorResponseDtoList.add(doctorResponseDto);
        }

        return doctorResponseDtoList;
    }

    @Override
    public DoctorResponseDto updateDoctor(Long id, DoctorRequestDto doctorRequestDto) {
        Doctor doctor = doctorRepository.findById(id).orElse(null);

        if(doctor != null) {
            doctor.setName(doctorRequestDto.getName());
            doctor.setCity(doctorRequestDto.getCity());
            doctor.setEmail(doctorRequestDto.getEmail());
            doctor.setPhone(doctorRequestDto.getPhone());
            doctor.setSpeciality(doctorRequestDto.getSpeciality());

            doctorRepository.save(doctor);
        }

        DoctorResponseDto doctorResponseDto = new DoctorResponseDto();
        doctorResponseDto.setId(doctor.getId());
        doctorResponseDto.setName(doctor.getName());
        doctorResponseDto.setCity(doctor.getCity());
        doctorResponseDto.setEmail(doctor.getEmail());
        doctorResponseDto.setPhone(doctor.getPhone());
        doctorResponseDto.setSpeciality(doctor.getSpeciality());

        return doctorResponseDto;
    }

    @Override
    public GenericResponseDto removeDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElse(null);

        GenericResponseDto genericResponseDto = new GenericResponseDto();

        if(doctor != null) {
            String name = doctor.getName();
            doctorRepository.deleteById(id);

            genericResponseDto.setSuccess(true);
            genericResponseDto.setMessage("Doctor name: " + name + " has been removed successfully");

            return genericResponseDto;
        }

        genericResponseDto.setSuccess(false);
        genericResponseDto.setMessage("Doctor id: " + id + " doesn't exist");

        return genericResponseDto;
    }
}
