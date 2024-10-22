package org.jsp.controller;

import java.time.LocalTime;
import java.util.Optional;

import org.jsp.dao.UserDao;
import org.jsp.entity.Faculty;
import org.jsp.entity.User;
import org.jsp.repository.FacultyRepository;
import org.jsp.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/faculties")
public class FacultyController {
	
	
	
	@Autowired
	private FacultyService service;
	
	@PostMapping("/{uid}")
	public ResponseEntity<?> saveFaculty(@RequestBody Faculty faculty,@PathVariable int uid)
	{
		return service.saveFaculty(faculty,uid);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findFacultyById(@PathVariable int uid)
	{
		return service.findFacultyById(uid);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllFaculties()
	{
		return service.findAllFaculties();
	}

	@PatchMapping(value = "/{uid}/{did}")
	public ResponseEntity<?> assignDepartmentToFacultyProfile(@PathVariable int uid,
			@PathVariable int did) {
		return service.assignDepartmentToFacultyProfile(uid, did);
	}
	
	@PatchMapping(value = "/{fid}")
	public ResponseEntity<?> setOfficeHoursToFaculty(@PathVariable int fid,@RequestBody LocalTime officeHours)
	{
		return service.setOfficeHoursToFaculty(fid,officeHours);
	}
	
	
	
	
	
	
}
