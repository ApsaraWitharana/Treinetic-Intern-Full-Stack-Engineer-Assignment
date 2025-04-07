package lk.ijse.gdse68.userservice.util;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum RoleEnum {
    USER, ADMIN, OTHER;
    @JsonCreator
    public static RoleEnum fromString(String role) {
        return RoleEnum.valueOf(role.toUpperCase());
    }
}
