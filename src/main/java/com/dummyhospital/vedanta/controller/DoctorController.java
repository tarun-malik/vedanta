package com.dummyhospital.vedanta.controller;

import com.dummyhospital.vedanta.dto.request.DoctorRequestDto;
import com.dummyhospital.vedanta.dto.response.DoctorResponseDto;
import com.dummyhospital.vedanta.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<DoctorResponseDto> register_doctor(@RequestBody DoctorRequestDto doctorRequestDto) {
        return new ResponseEntity<>(doctorService.registerDoctor(doctorRequestDto), HttpStatusCode.valueOf(201));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponseDto> get_doctor(@PathVariable Long id) {
        return new ResponseEntity<>(doctorService.getDoctor(id), HttpStatusCode.valueOf(200));
    }


}
