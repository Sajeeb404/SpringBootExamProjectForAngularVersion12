package com.example.demoForGreenDelta.services;

import com.example.demoForGreenDelta.model.EmployeeModel;
import com.example.demoForGreenDelta.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;
    public void saveEmploye(EmployeeModel employeem){
        if (employeem.getFirst_name().isEmpty() && employeem.getFirst_name().equals("")){
            System.out.println("Please first Name");
        }else {
            employeeRepo.save(employeem);
        }
    }


}
