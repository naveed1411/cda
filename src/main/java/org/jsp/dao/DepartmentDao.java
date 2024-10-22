package org.jsp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.entity.Department;

public interface DepartmentDao {

	Optional<Department> findDepartmentById(int did);

	

	List<Department> findAllDepartments();



	Department saveDepartment(Department department);

}
