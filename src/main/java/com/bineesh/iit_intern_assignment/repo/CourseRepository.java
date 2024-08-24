package com.bineesh.iit_intern_assignment.repo;


import com.bineesh.iit_intern_assignment.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
}
