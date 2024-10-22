package org.jsp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.entity.Course;

public interface CourseDao {

	Course saveCourse(Course course);

	Optional<Course> findCourseById(int id);

	List<Course> findAllCourses();

	void deleteCourseById(int id);

}
