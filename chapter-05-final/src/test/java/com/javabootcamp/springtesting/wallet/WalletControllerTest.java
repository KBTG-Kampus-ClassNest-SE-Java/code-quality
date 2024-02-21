package com.javabootcamp.springtesting.wallet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class WalletControllerTest {

    MockMvc mockMvc;
    @Mock
    WalletService walletService;

    @BeforeEach
    void setUp() {
        WalletController walletController = new WalletController(walletService);
        mockMvc = MockMvcBuilders.standaloneSetup(walletController)
                .alwaysDo(print())
                .build();
    }

    @Test
    @DisplayName("when perform on GET: /api/wallets/me should return Hello, Wallet!")
    void walletMessage() throws Exception {
        mockMvc.perform(get("/api/wallets/me"))
                .andExpect(jsonPath("$.message", is("Hello, Wallet!")))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("when perform on GET: /api/wallets should return Java and Kotlin wallets")
    void viewWallet() throws Exception {
        Wallet javaWallet = new Wallet();
        javaWallet.setWalletName("Java Wallet");

        Wallet kotlinWallet = new Wallet();
        kotlinWallet.setWalletName("Kotlin Wallet");

        when(walletService.getWalletList()).thenReturn(List.of(javaWallet, kotlinWallet));

        mockMvc.perform(get("/api/wallets"))
                .andExpect(jsonPath("$[0].walletName", is("Java Wallet")))
                .andExpect(jsonPath("$[1].walletName", is("Kotlin Wallet")))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("when create Java wallet on POST: /api/wallets should return status 200 and body contain Java wallet")
    void createWallet() throws Exception {
        Wallet wallet = new Wallet();
        wallet.setWalletName("Java Wallet");

        when(walletService.createWallet(any()))
                .thenReturn(wallet);

        mockMvc.perform(
                        post("/api/wallets")
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON)
                                .content("{\"name\":\"Java Wallet\"}")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.walletName", is("Java Wallet")));
    }
}