package org.jsp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.entity.Faculty;

public interface FacultyDao {

	Faculty saveFaculty(Faculty faculty);

	Optional<Faculty> findFacultyById(int uid);

	List<Faculty> findAllFaculties();

}
