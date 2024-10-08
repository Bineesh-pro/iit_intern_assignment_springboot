package com.bineesh.iit_intern_assignment.controller;


import com.bineesh.iit_intern_assignment.entity.Course;
import com.bineesh.iit_intern_assignment.entity.CourseDelivery;
import com.bineesh.iit_intern_assignment.model.CourseDeliveryRequest;
import com.bineesh.iit_intern_assignment.service.CourseDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("instances")
@CrossOrigin
public class CourseDeliveryController {

    @Autowired
    CourseDeliveryService courseDeliveryService;

    @PostMapping
    public CourseDelivery postCourseDelivery(@RequestBody CourseDeliveryRequest courseDeliveryRequest){
        return courseDeliveryService.saveCourseDelivery(courseDeliveryRequest);
    }

    @GetMapping
    public List<CourseDelivery> getCourseDelivery(
            @RequestParam(required = false,defaultValue = "0") int year,
            @RequestParam(required = false,defaultValue = "0") int semester,
            @RequestParam(required = false,defaultValue = "0") int courseId
    ) {
        System.out.println(year);
        return courseDeliveryService.getCourseDelivery(year,semester,courseId);
    }

    @DeleteMapping("{year}/{semester}/{courseId}")
    public String deleteCourseDelivery(@PathVariable int year,@PathVariable int semester,@PathVariable int courseId){
        return courseDeliveryService.deleteCourseDelivery(year,semester,courseId);
    }

}
