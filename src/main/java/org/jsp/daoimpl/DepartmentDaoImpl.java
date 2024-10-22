package org.jsp.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.dao.DepartmentDao;
import org.jsp.entity.Department;
import org.jsp.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
	
	@Autowired
	private DepartmentRepository repository;

	@Override
	public Optional<Department> findDepartmentById(int did) {
		
		return repository.findById(did);
	}

	

	@Override
	public List<Department> findAllDepartments() {
		return repository.findAll();
	}



	@Override
	public Department saveDepartment(Department department) {
		return repository.save(department);
	}

}
