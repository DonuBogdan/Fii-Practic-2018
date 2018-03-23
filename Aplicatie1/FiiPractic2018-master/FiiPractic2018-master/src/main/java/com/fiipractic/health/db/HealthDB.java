package com.fiipractic.health.db;

import com.fiipractic.health.model.Doctor;
import com.fiipractic.health.model.Pacient;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HealthDB {

    private Map<Long,Doctor> doctors;
    private Map<Long,Pacient> pacients;

    public HealthDB()
    {
        // initializam un hashmap ca sa nu avem null exception
        this.doctors=new HashMap<>();
        this.pacients=new HashMap<>();
//        Doctor doctor=new Doctor();
//        doctor.setId(1L);
//        doctor.setName("Doctor 1");
//        doctor.setFunction("chirurg");
//
//        doctors.put(doctor.getId(), doctor);
    }

    public List<Doctor> getDoctors()
    {
        return new ArrayList<Doctor>(doctors.values());
    }

    public Doctor getDoctor(Long id)
    {
        return doctors.get(id);
    }

    public Doctor saveDoctor(Doctor doctor)
    {
        // adaugam in mapa doctorul
        this.doctors.put(doctor.getId(), doctor);
        return doctor;

    }

    public void deleteDoctor(Doctor doctor) {
        this.doctors.remove(doctor.getId());
    }

    public Doctor updateDoctor(Doctor doctor) {

        this.doctors.put(doctor.getId(), doctor);
        return doctor;
    }

    public List<Pacient> getPacients()
    {
        return new ArrayList<Pacient>(pacients.values());
    }


    public Pacient getPacient(Long id)
    {
        return pacients.get(id);
    }

    public Pacient savePacient(Pacient pacient)
    {
        this.pacients.put(pacient.getId(), pacient);
        return pacient;

    }

    public void deletePacient(Pacient pacient) {
        this.pacients.remove(pacient.getId());
    }

    public Pacient updatePacient(Pacient pacient) {

        this.pacients.put(pacient.getId(), pacient);
        return pacient;
    }

}
