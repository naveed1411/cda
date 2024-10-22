package org.jsp.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.dao.CourseDao;
import org.jsp.entity.Course;
import org.jsp.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDaoImpl implements CourseDao
{
	@Autowired
	private CourseRepository repository;

	@Override
	public Course saveCourse(Course course) {
		return repository.save(course);
	}

	@Override
	public Optional<Course> findCourseById(int id) {
		return repository.findById(id);
	}

	@Override
	public List<Course> findAllCourses() {
		return repository.findAll();
	}

	@Override
	public void deleteCourseById(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
