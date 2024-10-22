package org.jsp.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class NoCourseFoundException extends RuntimeException {
String message;
}
