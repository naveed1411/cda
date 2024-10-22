package org.jsp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.entity.StudentProfile;

public interface StudentProfileDao {

	StudentProfile saveStudentProfile(StudentProfile s);

	List<StudentProfile> findAllStudentProfiles();

	Optional<StudentProfile> findStudentProfileById(int id);

	

}
