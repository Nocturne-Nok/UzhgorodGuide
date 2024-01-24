package com.telegram.uzhgorodguide.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public abstract class Entity {
    protected final UUID id;
    protected List<String> errors = new ArrayList();
    protected boolean isValid;

    protected Entity(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return this.id;
    }

    public boolean isValid() {
        return this.errors.isEmpty();
    }

    public List<String> getErrors() {
        return this.errors;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Entity entity = (Entity)o;
            return Objects.equals(this.id, entity.id);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id});
    }
}
