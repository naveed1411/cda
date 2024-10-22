package org.jsp.service;

import org.jsp.entity.Course;
import org.springframework.http.ResponseEntity;

public interface CourseService {

	ResponseEntity<?> saveCourse(Course course);

	ResponseEntity<?> findCourseById(int id);

	ResponseEntity<?> assignFacultyToCourse(int id, int fid);

	ResponseEntity<?> findAllCourses();

	ResponseEntity<?> deleteCourseById(int id);

	ResponseEntity<?> assignDepartmentToCourse(int id, int did);

}
