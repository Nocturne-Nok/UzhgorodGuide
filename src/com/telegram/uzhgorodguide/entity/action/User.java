package com.telegram.uzhgorodguide.entity.action;

import com.telegram.uzhgorodguide.entity.Entity;
import com.telegram.uzhgorodguide.entity.exception.EntityArgumentException;
import com.telegram.uzhgorodguide.entity.exception.TemplatesError;

import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;

public class User extends Entity {
    private String username;
    private final String password;
    private String email;
    private boolean isAdmin = false;

    public User(String username, String password, String email, UUID id) {
        super(id);
        this.setUsername(username);
        this.password = this.validatedPassword(password);
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        String templateName = "логіну";
        if (username.isBlank()) {
            this.errors.add(TemplatesError.REQUIRED.getTemplate().formatted("логіну"));
        }

        if (username.length() < 3) {
            this.errors.add(TemplatesError.MIN_LENGTH.getTemplate().formatted("логіну", 3));
        }

        if (username.length() > 26) {
            this.errors.add(TemplatesError.MAX_LENGTH.getTemplate().formatted("логіну", 26));
        }

        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_]+$");
        if (pattern.matcher(username).matches()) {
            this.errors.add(TemplatesError.ONLY_LATIN.getTemplate().formatted("логіну", 26));
        }

        if (!this.errors.isEmpty()) {
            throw new EntityArgumentException(this.errors);
        } else {
            this.username = username;
        }
    }

    private String validatedPassword(String password) {
        String templateName = "паролю";
        if (password.isBlank()) {
            this.errors.add(TemplatesError.REQUIRED.getTemplate().formatted("паролю"));
        }

        if (password.length() < 8) {
            this.errors.add(TemplatesError.MIN_LENGTH.getTemplate().formatted("паролю", 4));
        }

        if (password.length() > 32) {
            this.errors.add(TemplatesError.MAX_LENGTH.getTemplate().formatted("паролю", 32));
        }

        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$");
        if (pattern.matcher(password).matches()) {
            this.errors.add(TemplatesError.PASSWORD.getTemplate().formatted("паролю", 24));
        }

        if (!this.errors.isEmpty()) {
            throw new EntityArgumentException(this.errors);
        } else {
            return password;
        }
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            User user = (User)o;
            return Objects.equals(this.email, user.email);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.email});
    }

    public String toString() {
        String var10000 = this.password;
        return "User{password='" + var10000  + ", email='" + this.email + "', username='" + this.username + "', id=" + String.valueOf(this.id) + "}";
    }
}
