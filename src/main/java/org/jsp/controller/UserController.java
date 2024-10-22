package org.jsp.controller;

import org.jsp.entity.User;
import org.jsp.service.UserService;
import org.jsp.util.AuthUser;
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
@RequestMapping(value = "/users")
public class UserController {
	
	
	
	
	@Autowired
	UserService service;

	
	@Operation(summary = "To login",description = "This accepts one request body with two fields (username and password) and if both username and password match then it will successfully login that particular user.")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Login successfull..."),@ApiResponse(responseCode = "400",description = "Invalid username or password.....")})
	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody AuthUser authUser) {
		return service.login(authUser);
	}
	
	@Operation(summary = "To save the user",description = "This accepts one request body and saves the user details into the database.")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "User saved successfully.....")})
	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	@Operation(summary = "To find user by id ",description = "This accepts one path variable that is the id of the user whose details is to be fetched .If the user if found it will return the details of the user.")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "User found successfully..."),@ApiResponse(responseCode = "400",description = "Invalid Id.....")})
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findUserById(@PathVariable int id) {
		return service.findUserById(id);
	}

	@Operation(summary = "To fetch all the users",description = "This will fetch all the users available in the database")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "All Users Found Successfully..."),@ApiResponse(responseCode = "400",description = "No users found in the database.")})
	@GetMapping
	public ResponseEntity<?> findAllUsers() {
		return service.findAllUsers();
	}

}
