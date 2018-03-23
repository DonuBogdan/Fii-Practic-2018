package com.fiipractic.health.service;
import com.fiipractic.health.model.Pacient;

import java.util.List;
public interface PacientService {

    List<Pacient> getPacients();

    public Pacient getPacient(Long id);

    public Pacient savePacient(Pacient pacient);

    void deletePacient(Pacient pacient);

    Pacient updatePacient(Pacient pacient);
}
