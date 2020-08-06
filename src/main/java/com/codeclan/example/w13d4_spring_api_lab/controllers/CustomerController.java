package com.codeclan.example.w13d4_spring_api_lab.controllers;

import com.codeclan.example.w13d4_spring_api_lab.models.Customer;
import com.codeclan.example.w13d4_spring_api_lab.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value="/customers")
    public ResponseEntity<List<Customer>> getCustomersAndFilter(
            @RequestParam(required = false, name = "course") Long customerId){
        if (customerId != null) {
            return new ResponseEntity<>(customerRepository.findByBookingsCourseId(customerId), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
}
