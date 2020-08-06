package com.codeclan.example.w13d4_spring_api_lab.repositories;

import com.codeclan.example.w13d4_spring_api_lab.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseId(Long id);

    List<Customer> findByTownAndBookingsCourseId(String townName, Long id);
}
