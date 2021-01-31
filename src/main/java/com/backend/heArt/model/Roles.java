package com.backend.heArt.model;

public enum Roles {
    ROLE_ADMIN("Admin", 1), ROLE_USER("User", 2);

    String roleName;
    int roleId;

    public String getRoleName() {
        return roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    Roles(String admin, int i) {
    }
}
