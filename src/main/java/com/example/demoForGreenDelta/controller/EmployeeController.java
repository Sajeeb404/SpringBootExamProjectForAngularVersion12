package com.example.demoForGreenDelta.controller;


import com.example.demoForGreenDelta.model.EmployeeModel;
import com.example.demoForGreenDelta.repo.EmployeeRepo;
import com.example.demoForGreenDelta.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class EmployeeController {
    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    EmployeeService employeeService;


    // this is addEmployee Method start
    @PostMapping("/addEmployee")
    public ResponseEntity<EmployeeModel> addEmpolyee(@RequestBody EmployeeModel employeeModel) {
        try {
            employeeService.saveEmploye(employeeModel);

            return new ResponseEntity<>(employeeModel, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    // this is addEmployee Method end


    // this is updateEmployee Method start
    @PutMapping("/updateEmployee")
    public ResponseEntity<EmployeeModel> updateEmpolyee(@RequestBody EmployeeModel employeeModel) {


        try {
            EmployeeModel model = employeeRepo.save(employeeModel);
            return new ResponseEntity<>(model, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // this is updateEmployee Method end




    //this is getEmployee Medtho start
    @GetMapping("/getAllEmployee")
    public ResponseEntity<List<EmployeeModel>> getAllEmployee() {
        try {
            List<EmployeeModel> employeeList = new ArrayList<>();
            employeeRepo.findAll().forEach(employeeList::add);

            if (employeeList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employeeList, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //this is getEmployee Medtho end


    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<EmployeeModel> getEmployeeById(@PathVariable Long id) {
        Optional<EmployeeModel> bookObj = employeeRepo.findById(id);
        if (bookObj.isPresent()) {
            return new ResponseEntity<>(bookObj.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    //this is deleteemployeebyID Medtho start
    @DeleteMapping("/deleteEmployeeById/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id) {
        try {
            employeeRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //this is deleteemployeebyID Medtho end
}
