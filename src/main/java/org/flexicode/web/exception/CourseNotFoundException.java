package org.flexicode.web.exception;

import lombok.Getter;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

@Getter
public class CourseNotFoundException extends ResourceNotFoundException {

    private final String message;
    public CourseNotFoundException(String message){
        super();
        this.message = message;
    }
}
