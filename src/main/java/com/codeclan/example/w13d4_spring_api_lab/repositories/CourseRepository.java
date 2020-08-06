package com.codeclan.example.w13d4_spring_api_lab.repositories;

import com.codeclan.example.w13d4_spring_api_lab.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course>  findByRating(int rating);
}
