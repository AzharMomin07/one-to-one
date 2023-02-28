package com.crossasyst.onetoone.controller;

import com.crossasyst.onetoone.entity.PatientEntity;
import com.crossasyst.onetoone.model.PatientRequest;
import com.crossasyst.onetoone.model.PatientResponse;
import com.crossasyst.onetoone.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping(path = "/patient")
    public ResponseEntity<PatientResponse> createPatient(@RequestBody PatientRequest patientRequest) {
        PatientResponse patientResponse = patientService.createPatient(patientRequest);
        return new ResponseEntity<>(patientResponse, HttpStatus.CREATED);
    }

    @GetMapping(path = "patient/{patientId}")
    public ResponseEntity<PatientRequest> getPatientById(@PathVariable Long patientId) {
        PatientRequest patientRequest = patientService.getPatientById(patientId);
        return new ResponseEntity<>(patientRequest, HttpStatus.OK);

    }

    @GetMapping(path = "/patient")
    public ResponseEntity<List<PatientRequest>> getAllPatients() {
        List<PatientRequest> patientRequest = patientService.getAllPatients();
        return new ResponseEntity<>(patientRequest, HttpStatus.OK);
    }

    @PutMapping(path = "/patient/{patientId}")
    public ResponseEntity<PatientRequest>updatePatient(@PathVariable Long patientId,@RequestBody PatientRequest patientRequest){
    PatientRequest patientRequest1 = patientService.updatePatient(patientId,patientRequest);
    return new ResponseEntity<>(patientRequest1,HttpStatus.OK);
    }

    @DeleteMapping(path = "/patient/{patientId}")
    public void deleteById(@PathVariable Long patientId) {
        patientService.deleteById(patientId);
    }

}
