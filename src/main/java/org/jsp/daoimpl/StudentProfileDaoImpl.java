package org.jsp.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.dao.StudentProfileDao;
import org.jsp.entity.StudentProfile;
import org.jsp.repository.StudentProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class StudentProfileDaoImpl implements StudentProfileDao {
	
	@Autowired
	private StudentProfileRepository  repository;
	
	
	public StudentProfile saveStudentProfile(StudentProfile studentProfile) {
		return repository.save(studentProfile);
	}
	public List<StudentProfile> findAllStudentProfiles() {
		return repository.findAll();
	}
	public Optional<StudentProfile> findStudentProfileById(int id) {
		return repository.findById(id);
	}

	
	

}
