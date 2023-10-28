package com.javabootcamp.springtesting.wallet;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Wallet createWallet(@Valid @RequestBody WalletRequestDto requestDto) throws Exception {
        return this.walletService.createWallet(requestDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteWalletById(@PathVariable Integer id) {
        this.walletService.deleteWalletById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}


