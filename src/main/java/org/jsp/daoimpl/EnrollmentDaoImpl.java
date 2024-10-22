package org.jsp.daoimpl;

import java.util.List;

import org.jsp.dao.EnrollmentDao;
import org.jsp.entity.Enrollment;
import org.jsp.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EnrollmentDaoImpl implements EnrollmentDao
{
	@Autowired
	private EnrollmentRepository repository;

	@Override
	public Enrollment saveEnrollment(Enrollment enrollment) {
		return repository.save(enrollment);
	}

	@Override
	public List<Enrollment> findEnrollmentByUserId(int uid) {
		return repository.findEnrollmentByUserId(uid);
	}

	@Override
	public List<Enrollment> findAllEnrollmentsByFacultyProfileId(int fid) {
		return repository.findAllEnrollmentsByFacultyProfileId(fid);
	}

}
