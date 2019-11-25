package com.kiran.springboot.StudentServices.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kiran.springboot.StudentServices.model.Course;
import com.kiran.springboot.StudentServices.model.Student;

@Component
public class StudentService {
	
	private static List<Student> studentList = new ArrayList<>();
	
	static {
		Course course1 = new Course("Course1", "Spring", "Learning Spring", Arrays
				.asList("Learn Spring", "Import Project", "First Example",
						"Second Example"));
		
		Course course2 = new Course("Course2", "Java", "Learning Java", Arrays
				.asList("Learn Java", "Import Project", "First Example",
						"Second Example"));
		
		Course course3 = new Course("Course3", "React", "Learning React", Arrays
				.asList("Learn React", "Import Project", "First Example",
						"Second Example"));
		
		Course course4 = new Course("Course4", "Boot", "Learning Spring Boot", Arrays
				.asList("Learn Boot", "Import Project", "First Example",
						"Second Example"));
		
		List<Course> courseList = new ArrayList<>();
		courseList.add(course1);
		courseList.add(course2);
		courseList.add(course3);
		courseList.add(course4);
		
		Student student1 = new Student("Student1", "Kiran", "Junior Software Engineer", courseList);
		Student student2 = new Student("Student2", "Bhatt", "Software Engineer", courseList);
		
		studentList.add(student1);
		studentList.add(student2);
	}
	
	public List<Student> retrieveAllStudents() {
		return studentList;
	}
	
	public Student retrieveStudent(String studentId) {
		if(null != studentId)
			for(Student student : studentList) {
				if(student.getId().equals(studentId)) {
					return student;
				}
			}
		return null;
	}
	
	public List<Course> retrieveCourses(String studentId) {
		Student student = retrieveStudent(studentId);
		if (student == null) {
			return null;
		}
		return student.getCourses();
	}
	
	public Course retrieveCourse(String studentId, String courseId) {
		Student student = retrieveStudent(studentId);
		if (student == null) {
			return null;
		}
		for (Course course : student.getCourses()) {
			if (course.getId().equals(courseId)) {
				return course;
			}
		}

		return null;
	}
	
	private SecureRandom secRandom = new SecureRandom();
	
	public Course addCourse(String studentId, Course course) {
		Student student = retrieveStudent(studentId);
		if(null == student) {
			return null;
		}
		
		String randomId = new BigInteger(130, secRandom).toString(32);
		course.setId(randomId);
		student.getCourses().add(course);
		return course;
	}
}
