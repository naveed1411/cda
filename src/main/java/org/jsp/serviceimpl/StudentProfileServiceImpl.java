package org.jsp.serviceimpl;


import java.util.List;
import java.util.Optional;

import org.jsp.dao.DepartmentDao;
import org.jsp.dao.StudentProfileDao;
import org.jsp.dao.UserDao;
import org.jsp.entity.Department;
import org.jsp.entity.StudentProfile;
import org.jsp.entity.User;
import org.jsp.exception.NoDepartmentFoundException;
import org.jsp.exception.UserNotFoundException;
import org.jsp.responsestructure.ResponseStructure;
import org.jsp.service.StudentProfileService;
import org.jsp.util.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;




@Service
public class StudentProfileServiceImpl implements StudentProfileService{
	
	@Autowired
	private StudentProfileDao dao;
	
	@Autowired
	private UserDao userdao;
	
	@Autowired
	private DepartmentDao departmentdao;

	@Override
	public ResponseEntity<?> saveStudentProfile(int uid) {
		Optional<User> op = userdao.findUserById(uid);
		if (op.isEmpty())
		{
			throw UserNotFoundException.builder().message("Invalid User ID ....").build();

		}
		User user = op.get();
		user.setRole(Role.STUDENT);
		userdao.saveUser(user);
		
		StudentProfile s = StudentProfile.builder().id(uid).user(user).build();
		s=dao.saveStudentProfile(s);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Student Saved Successfully...").body(s).build());
		
		
	}

	@Override
	public ResponseEntity<?> findAllStudentProfiles() {
		List<StudentProfile> studentList = dao.findAllStudentProfiles();
		if(studentList.isEmpty())
		{
			throw new RuntimeException("No students found in the database.");
		}

		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("All Students  Found Successfully.....").body(studentList).build());
	
	}

	@Override
	public ResponseEntity<?> findStudentProfileById(int id) {
		Optional<StudentProfile> op = dao.findStudentProfileById(id);
		if (op.isEmpty())
		{
			throw UserNotFoundException.builder().message("Invalid Student ID ....").build();

		}
			
		StudentProfile s = op.get();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Student  Found Successfully...").body(s).build());
	
	}

	@Override
	public ResponseEntity<?> assignDepartmentToStudentProfile(int uid, int did) {
		Optional<Department> op1 = departmentdao.findDepartmentById(did);
		if (op1.isEmpty())
		{
			throw NoDepartmentFoundException.builder().message("Invalid Department id...No such Department found..").build();
		}
		Optional<StudentProfile> op2 = dao.findStudentProfileById(uid);
		if (op2.isEmpty())
		{
			throw UserNotFoundException.builder().message("Invalid Student ID ....").build();

		}
		Department department = op1.get();
		StudentProfile studentProfile = op2.get();
		
		studentProfile.setDepartment(department);
		
		studentProfile = dao.saveStudentProfile(studentProfile);
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Department Assigned To Student  Successfully...").body(studentProfile).build());
	
	}

}
