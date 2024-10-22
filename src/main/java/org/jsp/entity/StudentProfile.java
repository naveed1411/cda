package org.jsp.entity;





import org.jsp.util.CourseYear;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentProfile {
	@Id
	private int id;
	@OneToOne
	@MapsId
	private User user;

	private String photo;
	
	@ManyToOne
	private Department department;
	
	@Enumerated(EnumType.STRING)
	private CourseYear year;

}
