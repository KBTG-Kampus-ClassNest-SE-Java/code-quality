package com.javabootcamp.springtesting.wallet;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping("")
    public List<Wallet> getWalletList() {
        return this.walletService.getWalletList();
    }

    @PostMapping("")
    public Wallet createWallet(@Valid @RequestBody WalletRequestDto requestDto) {
        return this.walletService.createWallet(requestDto);
    }
}


