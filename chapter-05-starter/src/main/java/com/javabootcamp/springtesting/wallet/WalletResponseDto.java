package com.javabootcamp.springtesting.wallet;

public class WalletResponseDto {

    private String walletName;
    private Boolean active;

    public WalletResponseDto(String walletName, Boolean active) {
        this.walletName = walletName;
        this.active = active;
    }

    public String getWalletName() {
        return walletName;
    }

    public Boolean getActive() {
        return active;
    }
}
