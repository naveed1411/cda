package org.jsp.service;

import java.time.LocalTime;

import org.jsp.entity.Faculty;
import org.springframework.http.ResponseEntity;

public interface FacultyService {

	ResponseEntity<?> saveFaculty(Faculty faculty, int uid);

	ResponseEntity<?> findFacultyById(int uid);

	ResponseEntity<?> findAllFaculties();

	ResponseEntity<?> assignDepartmentToFacultyProfile(int uid, int did);

	ResponseEntity<?> setOfficeHoursToFaculty(int fid, LocalTime officeHours);

}
