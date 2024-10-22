package org.jsp.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.dao.FacultyDao;
import org.jsp.entity.Faculty;
import org.jsp.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class FacultyDaoImpl implements FacultyDao
{
	
	

	@Autowired
	private FacultyRepository repository;

	@Override
	public Faculty saveFaculty(Faculty faculty) {
		
		
		return repository.save(faculty);
	}

	@Override
	public Optional<Faculty> findFacultyById(int uid) {
		return repository.findById(uid);
	}

	@Override
	public List<Faculty> findAllFaculties() 
	{
		return repository.findAll();
	}

}
