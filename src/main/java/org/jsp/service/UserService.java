package org.jsp.service;

import org.jsp.entity.User;
import org.jsp.util.AuthUser;
import org.springframework.http.ResponseEntity;

public interface UserService {

	

	ResponseEntity<?> saveUser(User user);

	ResponseEntity<?> findUserById(int id);

	ResponseEntity<?> findAllUsers();

	ResponseEntity<?> login(AuthUser authUser);

}
