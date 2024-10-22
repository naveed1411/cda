package org.jsp.serviceimpl;


import java.util.List;
import java.util.Optional;

import org.jsp.dao.DepartmentDao;
import org.jsp.entity.Department;
import org.jsp.exception.NoDepartmentFoundException;
import org.jsp.responsestructure.ResponseStructure;
import org.jsp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao dao;
	
	@Override
	public ResponseEntity<?> saveDepartment(Department department) {
		department= dao.saveDepartment(department);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().message("Department Saved successfully....").status(HttpStatus.OK.value()).body(department).build());

	}

	@Override
	public ResponseEntity<?> findAllDepartments() {
		List<Department> departments=dao.findAllDepartments();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().message("Departments fetched successfully....").status(HttpStatus.OK.value()).body(departments).build());

	}

	@Override
	public ResponseEntity<?> findDepartmentById(int id)
	{
		Optional<Department> op=dao.findDepartmentById(id);
		if(op.isEmpty())
		{
			throw NoDepartmentFoundException.builder().message("No department found in the database with such id ...").build();
			
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().message("Departments fetched successfully....").status(HttpStatus.OK.value()).body(op.get()).build());

	}

}
