package com.bineesh.iit_intern_assignment.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    int instanceId;

    String yearOfDelivery;

    int semester;

    @OneToMany
    List<Course> courses;


}
