package org.jsp.repository;

import java.util.Optional;

import org.jsp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("Select u from User u where u.username=:username and u.password=:password")
	Optional<User> login(String username, String password);

}
