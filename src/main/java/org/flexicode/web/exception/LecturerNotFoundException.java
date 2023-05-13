package org.flexicode.web.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;


@Getter
@NoArgsConstructor
public class LecturerNotFoundException extends ResourceNotFoundException {
    private String message;
    public LecturerNotFoundException(String s){
        super();
        message = s;
    }
}
