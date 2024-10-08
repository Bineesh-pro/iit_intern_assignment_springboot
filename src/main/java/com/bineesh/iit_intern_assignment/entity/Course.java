package com.bineesh.iit_intern_assignment.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int courseId;

    String tittle;

    String courseCode;

    String description;


}
