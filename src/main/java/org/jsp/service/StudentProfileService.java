package org.jsp.service;

import org.springframework.http.ResponseEntity;

public interface StudentProfileService {

	ResponseEntity<?> saveStudentProfile(int uid);

	ResponseEntity<?> findStudentProfileById(int id);

	ResponseEntity<?> findAllStudentProfiles();

	ResponseEntity<?> assignDepartmentToStudentProfile(int uid, int did);


}
