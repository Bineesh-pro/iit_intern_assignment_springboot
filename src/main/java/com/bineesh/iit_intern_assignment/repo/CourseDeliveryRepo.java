package com.bineesh.iit_intern_assignment.repo;


import com.bineesh.iit_intern_assignment.entity.CourseDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseDeliveryRepo extends JpaRepository<CourseDelivery,Integer> {

    CourseDelivery findByYearOfDeliveryAndSemester(int year, int semester);

    boolean existsByYearOfDeliveryAndSemester(int year, int semester);
}
