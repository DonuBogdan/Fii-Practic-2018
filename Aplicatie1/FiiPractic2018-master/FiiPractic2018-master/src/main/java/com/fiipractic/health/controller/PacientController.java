package com.fiipractic.health.controller;

import com.fiipractic.health.exceptions.BadRequestException;
import com.fiipractic.health.exceptions.NotFoundException;
import com.fiipractic.health.mapper.ObjectMapper;
import com.fiipractic.health.model.Pacient;
import com.fiipractic.health.service.PacientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/pacients")
public class PacientController {

    private PacientService pacientService;

    //injectam serviciul aici ca sa-l putem folosi
    @Autowired
    public PacientController(PacientService pacientService)
    {
        this.pacientService=pacientService;
    }

    @GetMapping
    public List<Pacient> getPacients(){
        return pacientService.getPacients();
    }

    // punem getMapping pentru a face legatura cu pacientul
    // la id-ul care il scriem in url ii asignam acestui id din @pv
    @GetMapping(value="/{id}")
    public Pacient getPacient(@PathVariable("id") Long id) throws NotFoundException {
        Pacient pacient = pacientService.getPacient(id);
        if(pacient == null){
            throw new NotFoundException(String.format("Pacient with id=%s was not found.", id));
        }
        return pacient;
    }

    // update
    @PutMapping(value = "/{id}")
    public Pacient updatePacient(@PathVariable("id") Long id, @RequestBody Pacient pacient) throws BadRequestException, NotFoundException {
        //validate request
        if(!id.equals(pacient.getId())){
            throw new BadRequestException("The id is not the same with id from object");
        }
        Pacient pacientDb = pacientService.getPacient(id);
        if(pacientDb == null){
            throw new NotFoundException(String.format("Pacient with id=%s was not found.", id));
        }
        // schimbi valoarea din bd
        ObjectMapper.map2PacientDb(pacientDb, pacient);
        return pacientService.updatePacient(pacientDb);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Pacient savePacient(@RequestBody Pacient pacient)
    {
        // apelam serviciul de salvare Pacient
        return pacientService.savePacient(pacient);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteDoctor(@PathVariable Long id) throws NotFoundException {
        Pacient pacientDb = pacientService.getPacient(id);
        if (pacientDb == null) {
            throw new NotFoundException(String.format("Pacient with id=%s was not found.", id));
        }
        pacientService.deletePacient(pacientDb);
    }

}
