package com.fiipractic.health.mapper;

import com.fiipractic.health.model.Doctor;
import com.fiipractic.health.model.Pacient;

public class ObjectMapper {

    public static void map2DoctorDb(Doctor doctorDb, Doctor doctorRequest){
        doctorDb.setName(doctorRequest.getName());
        doctorDb.setFunction(doctorRequest.getFunction());
    }


    public static void map2PacientDb(Pacient pacientDb, Pacient pacientRequest){
        pacientDb.setName(pacientRequest.getName());
        pacientDb.setDisease(pacientRequest.getDisease());
    }
}
