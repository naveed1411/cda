package org.jsp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.entity.User;

public interface UserDao {

	Optional<User> findUserById(int uid);

	User saveUser(User user);

	Optional<User> login(String username, String password);

	List<User> findAllUsers();

}
