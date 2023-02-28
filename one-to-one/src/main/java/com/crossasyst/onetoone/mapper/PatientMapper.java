package com.crossasyst.onetoone.mapper;

import com.crossasyst.onetoone.entity.PatientEntity;
import com.crossasyst.onetoone.model.PatientRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    PatientRequest EntityToModel(PatientEntity patientEntity);

    PatientEntity ModelToEntity(PatientRequest patientRequest);

    List<PatientRequest> ModelToEntities(List<PatientEntity> patientEntities);

}
