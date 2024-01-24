package com.telegram.uzhgorodguide.entity.action;

public class Role {
    private String names;
    private boolean isAdmin;

    public Role(String names, boolean isAdmin) {
        this.names = names;
        this.isAdmin = isAdmin;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public String getNames() {
        return names;
    }

}
