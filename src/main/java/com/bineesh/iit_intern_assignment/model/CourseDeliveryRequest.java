package com.bineesh.iit_intern_assignment.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDeliveryRequest {
    int instanceId;

    String yearOfDelivery;

    int semester;

    int courseId;
}
