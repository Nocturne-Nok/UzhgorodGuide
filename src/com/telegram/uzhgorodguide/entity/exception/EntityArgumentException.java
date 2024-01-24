package com.telegram.uzhgorodguide.entity.exception;

import java.util.List;

public class EntityArgumentException extends IllegalArgumentException {
    private final List<String> errors;

    public EntityArgumentException(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return this.errors;
    }
}
