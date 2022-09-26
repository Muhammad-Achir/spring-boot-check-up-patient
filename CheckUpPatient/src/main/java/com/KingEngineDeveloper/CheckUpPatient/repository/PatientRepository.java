/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.KingEngineDeveloper.CheckUpPatient.repository;

import com.KingEngineDeveloper.CheckUpPatient.entity.Patient;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Last
 */
public interface PatientRepository extends CrudRepository<Patient, Integer> {
    
    public List<Patient> findByStatus (String status);
    
}
