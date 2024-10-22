package org.jsp.repository;

import org.jsp.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentProfileRepository  extends JpaRepository<StudentProfile, Integer>{

}
