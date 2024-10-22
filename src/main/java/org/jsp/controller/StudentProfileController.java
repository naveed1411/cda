package org.jsp.controller;

import org.jsp.service.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/students")
public class StudentProfileController 
{
	
	
	@Autowired
	private StudentProfileService service;
	
	
	@Operation(summary = "To save the student.",description = "This accepts one path variable that is the user id of the student and it will save the student.")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Student saved successfully..."),@ApiResponse(responseCode = "400",description = "Invalid user id.....")})
	
	@PostMapping("/{uid}")
	public ResponseEntity<?> saveStudentProfile(@PathVariable int uid)
	{
		return service.saveStudentProfile(uid);
	}
	@Operation(summary = "To find the student by id .",description = "This accepts one path variable that is the user id of the student and it will find the student details.")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Student found successfully..."),@ApiResponse(responseCode = "400",description = "Invalid user id.....")})
	@GetMapping("/{id}")
	public ResponseEntity<?> findStudentProfileById(@PathVariable int id)
	{
		return service.findStudentProfileById(id);
	}
	@Operation(summary = "To find all the students.",description = "This will find all the students available in the database. ")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = " All Students found successfully..."),@ApiResponse(responseCode = "400",description = "No students found in the database .S")})
	@GetMapping
	public ResponseEntity<?> findAllStudentProfiles()
	{
		return service.findAllStudentProfiles();
	}
	@Operation(summary = "To assign a department to the student.",description = "This accepts two path variables the first one  is the user id of the student and the second is the department id and  it will assign the department to the student.")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Department assigned successfully..."),@ApiResponse(responseCode = "400",description = "Invalid user id or Invalid Department id.....")})
	
	@PatchMapping(value = "/{uid}/{did}")
	public ResponseEntity<?> assignDepartmentToStudentProfile(@PathVariable(name = "uid") int uid,@PathVariable(name = "did") int did)
	{
		return service.assignDepartmentToStudentProfile(uid,did);
	}

	

}
