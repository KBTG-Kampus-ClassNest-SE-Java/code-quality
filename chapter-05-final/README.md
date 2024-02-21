# Chapter 5: Spring Testing

## Step 0: Start and Stop Database with Docker Compose

```shell
docker compose up -d
docker compose down
```

## Step 1: Walkthrough project structure

- Dependencies 
  - Test (`starter-test`)

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
    @DisplayName("when perform on GET: /api/wallets/me should return Hello, Wallet!")
    void walletMessage() throws Exception {
        mockMvc.perform(get("/api/wallets/me"))
                .andExpect(jsonPath("$.message", is("Hello, Wallet!")))
                .andExpect(status().isOk());
    }
}
```

## Step 5: Create test for `GET: /api/wallets` with Mock

````java

@ExtendWith(MockitoExtension.class)
class WalletControllerTest {

    MockMvc mockMvc;
    @Mock
    WalletService walletService;

    @BeforeEach
    void setUp() {
        WalletController walletController = new WalletController(walletService);
        mockMvc = MockMvcBuilders.standaloneSetup(walletController)
                .build();
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
}
````

## Step 6: Create test for `POST: /api/wallets` with Mock

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
                .build();
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
```

* Using ObjectMapper

```java
        WalletRequestDto dto=new WalletRequestDto();
        dto.setName("Java Wallet");

        ObjectMapper objectMapper=new ObjectMapper();
        String json=objectMapper.writeValueAsString(wallet);
```

## Step 7: Using `Postman` and `Newman`

`GET: /api/wallets`

```javascript
pm.test("wallet should contain Java wallet", function () {
    pm.expect(pm.response.text()).to.include("Java Wallet");
});
pm.test("should return http status 200", function () {
    pm.response.to.have.status(200);
});
```

`GET: /api/wallets/me`

```javascript
pm.test("should return Hello, Wallet!", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.message).to.include("Hello, Wallet!")
});
```

## Step 8: Export Postman collection and run with `Newman`
Installation: [Newman](https://learning.postman.com/docs/collections/using-newman-cli/installing-running-newman/) 
```shell
newman run wallet-collection.json
```