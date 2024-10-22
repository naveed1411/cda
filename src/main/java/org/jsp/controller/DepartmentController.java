package org.jsp.controller;

import org.jsp.entity.Department;
import org.jsp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/departments")
public class DepartmentController 
{
	
	@Autowired
	private DepartmentService service;
	
	@Operation(summary = "To save a department .",description = "This accepts one request body and saves the department details into the database.")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Department saved successfully...")})
	@PostMapping
	public ResponseEntity<?> saveDepartment(@RequestBody Department department)
	{
		return service.saveDepartment(department);
	}
	
	@Operation(summary = "To fetch  all the  departments .",description = "This api is used to fetch all the departments present in the database.")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "All Departments fetched successfully..."),@ApiResponse(responseCode = "400",description = "No departments found in the database.")})
	@GetMapping
	public ResponseEntity<?> findAllDepartments()
	{
		return service.findAllDepartments();
	}
	
	@Operation(summary = "To assign a department to the student.",description = "This accepts two path variables the first one  is the user id of the student and the second is the department id and  it will assign the department to the student.")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Department assigned successfully..."),@ApiResponse(responseCode = "400",description = "Invalid user id or Invalid Department id.....")})
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findDepartmentById(@PathVariable int id)
	{
		return service.findDepartmentById(id);
	}
	

}
