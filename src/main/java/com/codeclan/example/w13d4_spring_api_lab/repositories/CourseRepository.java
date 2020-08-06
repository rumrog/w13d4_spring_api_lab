package com.codeclan.example.w13d4_spring_api_lab.repositories;

import com.codeclan.example.w13d4_spring_api_lab.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
