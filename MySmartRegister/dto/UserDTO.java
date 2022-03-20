package com.application.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long ID;
    private String lastName;
    private RoleDTO roleType;
}
