package org.jsp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.dao.FacultyDao;
import org.jsp.dao.StudentProfileDao;
import org.jsp.dao.UserDao;
import org.jsp.entity.User;
import org.jsp.exception.UserNotFoundException;
import org.jsp.responsestructure.ResponseStructure;
import org.jsp.service.UserService;
import org.jsp.util.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;




@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private StudentProfileDao studentDao;
	@Autowired
	private FacultyDao facultyDao;
	
	
	@Override
	public ResponseEntity<?> login(AuthUser authUser) {
		Optional<User> optional = userDao.login(authUser.getUsername(), authUser.getPassword());
		if (optional.isEmpty())
		{
			throw UserNotFoundException.builder().message("Invalid username or password.....")
			.build();
		}
			
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Login Successfull...").body(optional.get()).build());
	
	}

	@Override
	public ResponseEntity<?> saveUser(User user) {
		user = userDao.saveUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("User saved successfully.....").body(user).build());
	

	}

	@Override
	public ResponseEntity<?> findUserById(int id) {
		Optional<User> op = userDao.findUserById(id);
		if (op.isEmpty())
		{
			throw UserNotFoundException.builder().message("Invalid  Id .....").build();

		}
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("User found successfully...").body(op.get()).build());
	
	}

	@Override
	public ResponseEntity<?> findAllUsers() {
		List<User> ul = userDao.findAllUsers();
		if(ul.isEmpty())
		{
			throw new RuntimeException("No users found in the database.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("All Users Found Successfully...").body(ul).build());
	}

}
