package com.bineesh.iit_intern_assignment.controller;


import com.bineesh.iit_intern_assignment.entity.Course;
import com.bineesh.iit_intern_assignment.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("courses")
    public Course postCourse(@RequestBody Course course){
        return courseService.saveCourse(course);
    }

    @GetMapping("courses")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("courses/{courseId}")
    public Course getCourse(@PathVariable int courseId){
        return courseService.getCourseById(courseId);
    }

    @DeleteMapping("courses/{courseId}")
    public String deleteCourse(@PathVariable int courseId){
        return courseService.deleteCourseById(courseId);
    }
}
