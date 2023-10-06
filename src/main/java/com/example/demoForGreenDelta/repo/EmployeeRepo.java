package com.example.demoForGreenDelta.repo;

import com.example.demoForGreenDelta.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeModel, Long> {

}
