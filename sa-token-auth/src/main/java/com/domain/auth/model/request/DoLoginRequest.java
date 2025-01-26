package com.domain.auth.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class DoLoginRequest implements Serializable {

    @NotNull(message = "username 必传！")
    @NotBlank(message = "username 不能为空！")
    private String username;
    @NotNull(message = "password 必传！")
    @NotBlank(message = "password 不能为空！")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
