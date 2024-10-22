package org.jsp.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.dao.UserDao;
import org.jsp.entity.User;
import org.jsp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepository repository;

	@Override
	public Optional<User> findUserById(int uid) {
		return repository.findById(uid);
	}

	@Override
	public User saveUser(User user) {
		return repository.save(user);
	}

	@Override
	public Optional<User> login(String username, String password) {
		return repository.login(username, password);

	}

	@Override
	public List<User> findAllUsers() {
		return repository.findAll();
	}
}
