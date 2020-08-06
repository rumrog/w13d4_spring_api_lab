package com.codeclan.example.w13d4_spring_api_lab.components;

import com.apple.eawt.Application;
import com.codeclan.example.w13d4_spring_api_lab.models.Booking;
import com.codeclan.example.w13d4_spring_api_lab.models.Course;
import com.codeclan.example.w13d4_spring_api_lab.models.Customer;
import com.codeclan.example.w13d4_spring_api_lab.repositories.BookingRepository;
import com.codeclan.example.w13d4_spring_api_lab.repositories.CourseRepository;
import com.codeclan.example.w13d4_spring_api_lab.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component


public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;
    
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CourseRepository courseRepository;

    public void run(ApplicationArguments args) {
        Customer ben = new Customer("Ben", "Inverness", 54);
        customerRepository.save(ben);

        Customer bob = new Customer("Bob", "Aberdeen", 20);
        customerRepository.save(bob);

        Customer alice = new Customer("Alice", "Glasgow", 33);
        customerRepository.save(alice);

        Course javaCourse = new Course("java", "Edinburgh", 4);
        courseRepository.save(javaCourse);

        Course pythonCourse = new Course("python", "Inverness", 3);
        courseRepository.save(pythonCourse);

        Course cssCourse = new Course("css", "Edinburgh", 3);
        courseRepository.save(cssCourse);

        Booking benJavaCourse = new Booking("01-05-2020", ben, javaCourse);
        bookingRepository.save(benJavaCourse);

        Booking aliceJavaCourse = new Booking("02-05-2020", alice, javaCourse);
        bookingRepository.save(aliceJavaCourse);

        Booking bobPythonCourse = new Booking("03-05-2020", bob, pythonCourse);
        bookingRepository.save(bobPythonCourse);
        
        Booking bobCssCourse = new Booking("03-05-2020", bob, cssCourse);
        bookingRepository.save(bobCssCourse);
    }


}
