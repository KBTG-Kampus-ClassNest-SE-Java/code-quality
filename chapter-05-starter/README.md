# Chapter 5: Spring Testing

## Step 1: Walkthrough project structure

- Dependencies
    - Spring Test (`starter-test`)
    - Testcontainers (`testcontainers`)

## Step 2: Walkthrough Wallet application

- View all wallets: `GET api/wallets`
- Create a wallet: `POST api/wallets`

## Step 3: Create simple API

- `api/wallets/me`

```java

@RestController
@RequestMapping("/api/wallets")
public class WalletController { 
    @GetMapping("/me") 
    Message me() {
        return new Message("Hello, Wallet!");
    }
}

record Message(String message) {
}
```

## Step 4: Create test for API `GET: /api/wallets/me`
```java
@ExtendWith(MockitoExtension.class)
class WalletControllerTest {

    MockMvc mockMvc;
    @Mock
    WalletService walletService;

    @BeforeEach
    void setUp() {
        WalletController walletController = new WalletController(walletService);
        mockMvc = MockMvcBuilders.standaloneSetup(walletController)
//                .alwaysDo(print())
                .build();
    }

    @Test
    @DisplayName("when perform on /api/wallets/me should return Hello, Wallet!")
    void walletMessage() throws Exception {
        mockMvc.perform(get("/api/wallets/me"))
                .andExpect(jsonPath("$.message", is("Hello, Wallet!")))
                .andExpect(status().isOk());
    }
}
```

## Step 5: Create test for `GET: /api/wallets` with Mock

## Step 6: Create test for `POST: /api/wallets` with Mock

## Step 7: Create test for `GET: /api/wallets` with Testcontainers

## Step 8: Create test for `POST: /api/wallets` with Testcontainers

## Step 9: Using `Postman` and `Newman`