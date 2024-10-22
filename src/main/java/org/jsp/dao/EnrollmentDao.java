package org.jsp.dao;

import java.util.List;

import org.jsp.entity.Enrollment;

public interface EnrollmentDao {

	Enrollment saveEnrollment(Enrollment enrollment);

	List<Enrollment> findEnrollmentByUserId(int uid);

	List<Enrollment> findAllEnrollmentsByFacultyProfileId(int fid);

}
