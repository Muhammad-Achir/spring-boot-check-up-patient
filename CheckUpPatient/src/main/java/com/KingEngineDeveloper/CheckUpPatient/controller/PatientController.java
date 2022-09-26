/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.KingEngineDeveloper.CheckUpPatient.controller;

import com.KingEngineDeveloper.CheckUpPatient.entity.Patient;
import com.KingEngineDeveloper.CheckUpPatient.repository.PatientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Last
 */
@RestController
@RequestMapping("/api")
public class PatientController {
    
    @Autowired
    private PatientRepository PatientRepository;
    
//    Tester api
    @GetMapping("/hello")
    public ResponseEntity<String> hello () {
        return ResponseEntity.ok("Hello, Wellcome to check up page!");
    }
    
    @GetMapping("/checkup")
    public ResponseEntity<Iterable<Patient>> getPatients(){
        Iterable<Patient> patients = PatientRepository.findAll();
        return ResponseEntity.ok(patients);
    }
    
    @PostMapping("/checkup")
    public ResponseEntity<Patient> save(@RequestBody Patient patient){
        PatientRepository.save(patient);
        return ResponseEntity.ok(patient);
    }
    
    @PutMapping("/checkup/{id}/update-status")
    public ResponseEntity<Optional<Patient>> update(@RequestBody Patient patient, @PathVariable Integer id){
        Optional<Patient> patientToUpdate = PatientRepository.findById(id);
        
        if (patientToUpdate != null) {
            patientToUpdate.get().setStatus(patient.getStatus());
            PatientRepository.save(patientToUpdate.get());
            return ResponseEntity.ok(patientToUpdate);
        }
        return (ResponseEntity<Optional<Patient>>) ResponseEntity.notFound();
    }
}
