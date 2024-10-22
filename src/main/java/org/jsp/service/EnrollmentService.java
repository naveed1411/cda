package org.jsp.service;

import org.springframework.http.ResponseEntity;

public interface EnrollmentService {

	ResponseEntity<?> saveEnrollment(int uid, int cid);

	ResponseEntity<?> findEnrollmentByUserId(int uid);

	ResponseEntity<?> findAllEnrollmentsByFacultyProfileId(int fid);

}
