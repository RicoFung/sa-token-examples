package com.domain.auth.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class DoRenewTokenRequest implements Serializable {

    @NotNull(message = "refreshToken 必传！")
    @NotBlank(message = "refreshToken 不能为空！")
    private String refreshToken;

    public String getRefreshToken()
    {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken)
    {
        this.refreshToken = refreshToken;
    }
}
