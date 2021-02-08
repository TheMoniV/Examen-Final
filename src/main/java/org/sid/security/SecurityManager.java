package org.sid.security;

import org.springframework.stereotype.Component;

@Component
public class SecurityManager {
    private final static ThreadLocal<User> threadLocal = new ThreadLocal<>();

    public void login(String username, String password) {
        threadLocal.set(new User(null, username, password, new String[]{"USER"}));
    }

    public void logout() {
        threadLocal.set(null);
    }

    public User getLoggedOnUser() {
        return threadLocal.get();
    }
}
