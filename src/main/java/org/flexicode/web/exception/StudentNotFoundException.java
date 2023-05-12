package org.flexicode.web.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.function.Supplier;

@Getter
public class StudentNotFoundException extends ResourceNotFoundException {

    private  String message;
    public StudentNotFoundException(String s) {
        super();
        this.message = s;
    }
    public StudentNotFoundException(){
        super();
    }
}
