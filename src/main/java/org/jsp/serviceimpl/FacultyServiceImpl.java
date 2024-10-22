package org.jsp.serviceimpl;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.jsp.dao.DepartmentDao;
import org.jsp.dao.FacultyDao;
import org.jsp.dao.UserDao;
import org.jsp.entity.Department;
import org.jsp.entity.Faculty;
import org.jsp.entity.User;
import org.jsp.exception.NoDepartmentFoundException;
import org.jsp.exception.UserNotFoundException;
import org.jsp.responsestructure.ResponseStructure;
import org.jsp.service.FacultyService;
import org.jsp.util.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FacultyServiceImpl  implements FacultyService
{
	@Autowired
	private FacultyDao dao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public ResponseEntity<?> saveFaculty(Faculty faculty, int uid) {
		Optional<User> op= userDao.findUserById(uid);
		if(op.isEmpty())
		{
			throw UserNotFoundException.builder().message("No User found with the given id ").build();
		}
		op.get().setRole(Role.FACULTY);
		userDao.saveUser(op.get());
		faculty.setUser(op.get());
		faculty=dao.saveFaculty(faculty);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().message("Faculty Saved successfully....").status(HttpStatus.OK.value()).body(faculty).build());
	}

	@Override
	public ResponseEntity<?> findFacultyById(int uid) {
		
		Optional<Faculty> op= dao.findFacultyById(uid);
		if(op.isEmpty())
		{
			throw UserNotFoundException.builder().message("No User found with the given id ").build();
		}
		
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().message("Faculty Saved successfully....").status(HttpStatus.OK.value()).body(op.get()).build());

		
		
	}

	@Override
	public ResponseEntity<?> findAllFaculties() {
		List<Faculty> faculties=dao.findAllFaculties();
		if(faculties.isEmpty())
		{
			throw new RuntimeException("No Faculties found in the database.");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().message("Faculty Saved successfully....").status(HttpStatus.OK.value()).body(faculties).build());

	}

	@Override
	public ResponseEntity<?> assignDepartmentToFacultyProfile(int uid, int did) {
		Optional<Faculty> op= dao.findFacultyById(uid);
		if(op.isEmpty())
		{
			throw UserNotFoundException.builder().message("No User found with the given id ").build();
		}
		
		
		
		Optional<Department> op2=departmentDao.findDepartmentById(did);
		if(op.isEmpty())
		{
			throw NoDepartmentFoundException.builder().message("No Department found with the given id ").build();
		}
		
		Faculty f=op.get();
		f.setDepartment(op2.get());
		dao.saveFaculty(f);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().message("Department  assigned successfully....").status(HttpStatus.OK.value()).body(f).build());

		
	}

	@Override
	public ResponseEntity<?> setOfficeHoursToFaculty(int fid, LocalTime officeHours) {
		Optional<Faculty> op=dao.findFacultyById(fid);
		if(op.isEmpty())
		{
			throw UserNotFoundException.builder().message("No Faculty found with the given id ").build();

		}
		op.get().setOfficeHours(officeHours);
		Faculty f=dao.saveFaculty(op.get());
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().message("Office Hours  assigned successfully....").status(HttpStatus.OK.value()).body(f).build());

	}

}
