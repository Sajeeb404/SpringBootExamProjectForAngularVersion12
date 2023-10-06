package com.example.demoForGreenDelta.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Employees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeModel {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String first_name;
    private String last_name;

//    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birth_date;
    private String  phone_number;
    private String  gender;

    private String skill_name;
    private String experience;
    private String skill_level;


}
