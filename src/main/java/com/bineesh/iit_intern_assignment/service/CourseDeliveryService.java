package com.bineesh.iit_intern_assignment.service;


import com.bineesh.iit_intern_assignment.entity.Course;
import com.bineesh.iit_intern_assignment.entity.CourseDelivery;
import com.bineesh.iit_intern_assignment.model.CourseDeliveryRequest;
import com.bineesh.iit_intern_assignment.repo.CourseDeliveryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class CourseDeliveryService {

    @Autowired
    CourseDeliveryRepo courseDeliveryRepo;

    @Autowired
    CourseService courseService;

    public CourseDelivery saveCourseDelivery(CourseDeliveryRequest courseDeliveryRequest){
        if(courseDeliveryRepo.existsByYearOfDeliveryAndSemester(courseDeliveryRequest.getYearOfDelivery(),courseDeliveryRequest.getSemester())){
            CourseDelivery courseDelivery = courseDeliveryRepo.findByYearOfDeliveryAndSemester(courseDeliveryRequest.getYearOfDelivery(),courseDeliveryRequest.getSemester());
            List<Course> courses = courseDelivery.getCourses();
            courses.add(courseService.getCourseById(courseDeliveryRequest.getCourseId()));
            courseDelivery.setCourses(courses);
            return courseDeliveryRepo.save(courseDelivery);
        }else {
            CourseDelivery courseDelivery = new CourseDelivery();
            List<Course> courses = new ArrayList<>();
            courses.add(courseService.getCourseById(courseDeliveryRequest.getCourseId()));
            courseDelivery.setYearOfDelivery(courseDeliveryRequest.getYearOfDelivery());
            courseDelivery.setSemester(courseDeliveryRequest.getSemester());
            courseDelivery.setInstanceId(courseDeliveryRequest.getInstanceId());
            courseDelivery.setCourses(courses);
            return courseDeliveryRepo.save(courseDelivery);
        }
    }

    public List<CourseDelivery> getCourseDelivery(int year, int semester, int courseId) {
        List<CourseDelivery> courseDeliveryList = courseDeliveryRepo.findAll();
        if(year != 0){
            courseDeliveryList = courseDeliveryList
                    .stream().filter(cd -> cd.getYearOfDelivery() == year)
                    .toList();
        }
        if(semester != 0 && year != 0){
            courseDeliveryList = courseDeliveryList
                    .stream().filter(cd -> cd.getSemester() == semester)
                    .toList();
        }

        if(courseId != 0 ){
            courseDeliveryList = courseDeliveryList
                    .stream().filter(cd -> cd.getCourses().contains(courseService.getCourseById(courseId)))
                    .toList();
        }
        return courseDeliveryList;
    }

    public String deleteCourseDelivery(int year, int semester, int courseId) {
        Course course = courseService.getCourseById(courseId);
        CourseDelivery courseDelivery = courseDeliveryRepo.findByYearOfDeliveryAndSemester(year,semester);
        List<Course> courses = courseDelivery.getCourses();
        courses.remove(course);
        courseDelivery.setCourses(courses);
        courseDeliveryRepo.save(courseDelivery);
        return "Course Delivery deleted";
    }
}
