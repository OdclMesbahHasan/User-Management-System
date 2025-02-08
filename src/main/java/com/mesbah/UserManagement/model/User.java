package com.mesbah.UserManagement.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @NotBlank(message = "Email is required")
    private String firstName;
    private String lastName;
    private String email;
}
