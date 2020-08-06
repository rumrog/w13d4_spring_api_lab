package com.codeclan.example.w13d4_spring_api_lab.repositories;

import com.codeclan.example.w13d4_spring_api_lab.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
