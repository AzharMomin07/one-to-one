package com.crossasyst.onetoone.service;

import com.crossasyst.onetoone.controller.PatientController;
import com.crossasyst.onetoone.entity.PatientEntity;
import com.crossasyst.onetoone.mapper.PatientMapper;
import com.crossasyst.onetoone.model.PatientRequest;
import com.crossasyst.onetoone.model.PatientResponse;
import com.crossasyst.onetoone.repository.PatientRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class PatientService {
    private final PatientMapper patientMapper;
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientMapper patientMapper, PatientRepository patientRepository) {
        this.patientMapper = patientMapper;
        this.patientRepository = patientRepository;
    }

    public PatientResponse createPatient(PatientRequest patientRequest) {
        PatientEntity patientEntity = patientMapper.ModelToEntity(patientRequest);
        patientRepository.save(patientEntity);
        log.info("Patient Created Successfully");
        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setPatientId(patientEntity.getPatientId());
        return patientResponse;

    }

    public PatientRequest getPatientById(Long patientId) {
        PatientEntity patientEntity = patientRepository.getOne(patientId);
        PatientRequest patientRequest = patientMapper.EntityToModel(patientEntity);
        return patientRequest;
    }

    public List<PatientRequest> getAllPatients() {
        List<PatientEntity> patientEntity = patientRepository.findAll();
        List<PatientRequest> patientRequest = patientMapper.ModelToEntities(patientEntity);
        return patientRequest;
    }

    public void deleteById(Long patientId) {
        patientRepository.deleteById(patientId);
    }

    public PatientRequest updatePatient(Long patientId, PatientRequest patientRequest) {
//        PatientEntity patientEntity = patientRepository.findById(patientId).get();
//
//        PatientEntity patientEntity1 = patientMapper.ModelToEntity(patientRequest);
//        patientEntity1.setPatientId(patientEntity.getPatientId());


//        patientEntity.getAddress().setAddressId(patientEntity1.getAddress().getAddressId());
//        patientEntity1.setPatientId(patientEntity.getPatientId());
//        patientRepository.save(patientEntity1);
//        log.info("Updated Successfully");

        PatientEntity patientEntity = patientRepository.findById(patientId).get();
        PatientEntity patientEntity1 = patientMapper.ModelToEntity(patientRequest);
        patientEntity1.setPatientId(patientEntity.getPatientId());
        patientRepository.save(patientEntity1);
        log.info("Updated Successfully");
        return patientRequest;
    }
}
