package xyz.ps.controller.request;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class UserRequest {
    private String firstName;
    private String lastName;
    private String userName;
}
