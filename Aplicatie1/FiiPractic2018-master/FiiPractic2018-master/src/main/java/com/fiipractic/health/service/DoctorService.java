package com.fiipractic.health.service;

import com.fiipractic.health.model.Doctor;

import java.util.List;

public interface DoctorService {


    List<Doctor> getDoctors();

    public Doctor getDoctor(Long id);

    public Doctor saveDoctor(Doctor doctor);

    void deleteDoctor(Doctor doctor);

    Doctor updateDoctor(Doctor doctor);

}
