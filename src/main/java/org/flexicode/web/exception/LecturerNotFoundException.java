package org.flexicode.web.exception;

import lombok.Getter;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;


@Getter
public class LecturerNotFoundException extends ResourceNotFoundException {
    private final String message;
    public LecturerNotFoundException(String s){
        super();
        message = s;
    }
}
