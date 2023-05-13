package org.flexicode.web.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

@Getter
@NoArgsConstructor
public class CourseNotFoundException extends ResourceNotFoundException {

    private String message;
    public CourseNotFoundException(String message){
        super();
        this.message = message;
    }
}
