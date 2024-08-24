package com.bineesh.iit_intern_assignment.repo;

import com.bineesh.iit_intern_assignment.entity.Course;
import com.bineesh.iit_intern_assignment.entity.CourseDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CourseDeliveryRepo extends JpaRepository<CourseDelivery,Integer> {

    CourseDelivery findByYearOfDeliveryAndSemester(String year, int semester);

    boolean existsByYearOfDeliveryAndSemester(String year, int semester);
}
