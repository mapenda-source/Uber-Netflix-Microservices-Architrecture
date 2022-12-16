package com.mapenda.architecture_netflix_uber.models;

import lombok.Getter;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {

    private String username;
    private String password;

}