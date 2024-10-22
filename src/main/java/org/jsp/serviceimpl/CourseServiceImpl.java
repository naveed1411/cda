package org.jsp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.dao.CourseDao;
import org.jsp.dao.DepartmentDao;
import org.jsp.dao.FacultyDao;
import org.jsp.entity.Course;
import org.jsp.entity.Department;
import org.jsp.entity.Faculty;
import org.jsp.exception.NoCourseFoundException;
import org.jsp.exception.NoDepartmentFoundException;
import org.jsp.exception.UserNotFoundException;
import org.jsp.responsestructure.ResponseStructure;
import org.jsp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService
{
	
	@Autowired
	private CourseDao dao;

	@Autowired
	private FacultyDao facultyDao;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@Override
	public ResponseEntity<?> saveCourse(Course course) {
		course=dao.saveCourse(course);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().message("course saved successfully....").status(HttpStatus.OK.value()).body(course).build());

}

	@Override
	public ResponseEntity<?> findCourseById(int id) {
		Optional<Course> op=dao.findCourseById(id);
		if(op.isEmpty())
		{
			throw NoCourseFoundException.builder().message("No course found with the id ...").build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().message("course fetched successfully....").status(HttpStatus.OK.value()).body(op.get()).build());

	}

	@Override
	public ResponseEntity<?> assignFacultyToCourse(int id, int fid) {
		Optional<Faculty> op=facultyDao.findFacultyById(fid);
		if(op.isEmpty())
		{
			throw UserNotFoundException.builder().message("No faculty found with the given id ").build();
		}
		Optional<Course> op2=dao.findCourseById(id);
		if(op2.isEmpty())
		{
			throw NoCourseFoundException.builder().message("No course found with the given id ").build();
		}
		op2.get().setFaculty(op.get());
		dao.saveCourse(op2.get());
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().message("faculty assigned successfully....").status(HttpStatus.OK.value()).body(op2.get()).build());

	}

	@Override
	public ResponseEntity<?> findAllCourses() {
		List<Course> courses=dao.findAllCourses();
		if(courses.isEmpty())
		{
			throw NoCourseFoundException.builder().message("No course found ").build();

		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().message("all courses fetched  successfully....").status(HttpStatus.OK.value()).body(courses).build());

		
	}

	@Override
	public ResponseEntity<?> deleteCourseById(int id) {
		Optional<Course> op2=dao.findCourseById(id);
		if(op2.isEmpty())
		{
			throw NoCourseFoundException.builder().message("No course found with the given id ").build();
		}
		dao.deleteCourseById(id);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().message("course deleted successfully....").status(HttpStatus.OK.value()).body("Deletion Successfull.").build());

	}

	@Override
	public ResponseEntity<?> assignDepartmentToCourse(int id, int did) 
	{
		Optional<Department> op=departmentDao.findDepartmentById(did);
		if(op.isEmpty())
		{
			throw NoDepartmentFoundException.builder().message("No Department found with the given id").build();
		}
		Optional<Course> op2=dao.findCourseById(id);
		if(op2.isEmpty())
		{
			throw NoCourseFoundException.builder().message("No course found with the given id ").build();
		}
		op2.get().setDepartment(op.get());
		Course c=dao.saveCourse(op2.get());
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().message("Department assigned  successfully....").status(HttpStatus.OK.value()).body(c).build());

		
	
	}

}
