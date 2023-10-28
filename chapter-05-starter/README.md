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
    public String getMyWallet() {
        return "My wallet";
    }
}
```

## Step 4: Create test for API `GET: /api/wallets/me`

## Step 5: Create test for `GET: /api/wallets` with Mock

## Step 6: Create test for `POST: /api/wallets` with Mock

## Step 7: Create test for `GET: /api/wallets` with Testcontainers

## Step 8: Create test for `POST: /api/wallets` with Testcontainers

## Step 9: Using `Postman` and `Newman`