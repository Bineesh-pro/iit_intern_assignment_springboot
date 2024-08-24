package com.bineesh.iit_intern_assignment.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course {


    @Id
    int courseId;

    String tittle;

    String courseCode;

    String description;


}
