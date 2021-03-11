package com.backend.heArt.entity;

public enum Roles {
    ROLE_ARTIST("Artist", 0), ROLE_USER("User", 1);

    String roleName;
    int roleId;

    Roles(String admin, int i) {
    }
}