package com.bineesh.iit_intern_assignment.service;


import com.bineesh.iit_intern_assignment.entity.Course;
import com.bineesh.iit_intern_assignment.exception.CourseNotFoundException;
import com.bineesh.iit_intern_assignment.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public Course saveCourse(Course course){
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public Course getCourseById(int courseId){
        return courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException("no such course with id "+courseId));
    }

    public String deleteCourseById(int courseId){
        courseRepository.deleteById(courseId);
        return "deleted";
    }
}
