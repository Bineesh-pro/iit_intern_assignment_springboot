package com.bineesh.iit_intern_assignment.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDelivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int instanceId;

    int yearOfDelivery;

    int semester;

    @OneToMany
    List<Course> courses;


}
