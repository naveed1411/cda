package org.jsp.util;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AuthUser {
	public String username;
	private String password;

}
