package org.flexicode.web.requests;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.flexicode.web.entity.Post;
import org.flexicode.web.entity.Title;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LecturerRequest {
    private String firstname;
    private String lastname;
    private Title title;
    private Post Position;
    private List<String> course;

}
