package com.javabootcamp.springtesting.wallet;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class WalletRequestDto {

    @NotNull
    @Size(min = 3, max = 30, message = "Wallet name length should be 3-20 characters")
    private String name;

    public WalletRequestDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
