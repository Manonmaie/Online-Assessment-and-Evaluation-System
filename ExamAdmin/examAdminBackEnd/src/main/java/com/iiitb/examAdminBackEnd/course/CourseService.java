package com.iiitb.examAdminBackEnd.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses() {
		List<Course> courses = new ArrayList<>();
		courseRepository.findAll().forEach(courses::add);
		return courses;
	}

	public void deleteCourse(int id) {
		courseRepository.deleteById(id);
	}
	
	public Optional<Course> getCourse(int id){
		return courseRepository.findById(id);
	}
	
	public void addCourse(Course course) {
		courseRepository.save(course);
	}
}