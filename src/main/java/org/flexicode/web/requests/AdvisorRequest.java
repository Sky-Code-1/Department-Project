package org.flexicode.web.requests;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class AdvisorRequest {

    @NonNull
    private String level;
    @NonNull
    private String email;

}
