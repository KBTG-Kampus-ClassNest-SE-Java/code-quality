package com.javabootcamp.springtesting.wallet;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public List<Wallet> getWalletList() {
        return walletRepository.findAll();
    }

    public Wallet createWallet(WalletRequestDto requestDto) {
        Wallet wallet = new Wallet();
        wallet.setWalletName(requestDto.getName());
        wallet.setActive(true);

        walletRepository.save(wallet);
        return wallet;
    }
}
