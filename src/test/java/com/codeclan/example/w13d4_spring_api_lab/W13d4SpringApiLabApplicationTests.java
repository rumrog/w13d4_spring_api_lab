package com.codeclan.example.w13d4_spring_api_lab;

import com.codeclan.example.w13d4_spring_api_lab.models.Booking;
import com.codeclan.example.w13d4_spring_api_lab.models.Course;
import com.codeclan.example.w13d4_spring_api_lab.models.Customer;
import com.codeclan.example.w13d4_spring_api_lab.repositories.BookingRepository;
import com.codeclan.example.w13d4_spring_api_lab.repositories.CourseRepository;
import com.codeclan.example.w13d4_spring_api_lab.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
class W13d4SpringApiLabApplicationTests {

    @Autowired
	CustomerRepository customerRepository;

    @Autowired
	BookingRepository bookingRepository;

    @Autowired
	CourseRepository courseRepository;

	@Test
	public void contextLoads(){
	}

	@Test
	public void canCreateCustomersAndCoursesAndBookings(){
		Customer ben = new Customer("Ben", "Inverness", 54);
		customerRepository.save(ben);
		Course javaCourse = new Course("java", "Edinburgh", 4);
		courseRepository.save(javaCourse);
		Booking benJavaCourse = new Booking("01-05-2020", ben, javaCourse);
		bookingRepository.save(benJavaCourse);
		Customer customer = customerRepository.getOne(1L);
		assertEquals("Ben", customer.getName());
	}

	@Test
	public void canGetAllCustomers(){
		List<Customer> customers = customerRepository.findAll();
		Optional<Customer> customer = customerRepository.findById(1L);
		assertEquals(3, customers.size());
		assertEquals("Ben", customer.get().getName());
	}

	@Test
	public void canFindCoursesByStarRating(){
		List<Course> foundCourses = courseRepository.findByRating(4);
		assertEquals(1, foundCourses.size());
	}

	@Test
	public void canFindCustomerByCourse(){
		List<Customer> foundCustomers = customerRepository.findByBookingsCourseId(1L);
		assertEquals(2, foundCustomers.size() );
	}

}
