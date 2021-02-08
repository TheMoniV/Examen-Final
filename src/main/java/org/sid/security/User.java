package org.sid.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Arrays;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private Long id;
    private String username;
    private String password;
    private String[] roles;

    public boolean hasRole(String role) {
        return Arrays.stream(roles).anyMatch(_role -> _role.equals(role));
    }
}
