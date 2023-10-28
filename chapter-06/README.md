# Chapter 6: Test-Driven Development

## Step 0: Create test file
- `FizzBuzzTest.java`

## Step 1: Write a failing test

- `FizzBuzzTest.java`
```java
class FizzBuzzTest {
    
    @Test
    @DisplayName("input 1 should return 1")
    void input1ShouldReturn1() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        String actual = fizzBuzz.fizzBuzz(1);

        assertEquals("1", actual);
    }
}
```

- `FizzBuzz.java`
```java
class FizzBuzz {
    String fizzBuzz(int input) {
        return null;
    }
}
```

## Step 2: Make the test pass
- `FizzBuzz.java`
```java
class FizzBuzz {
    String fizzBuzz(int input) {
        return "1";
    }
}
```

## Step 3: Add input 2 return "2"
 
- `FizzBuzzTest.java`

```java
class FizzBuzzTest {

    @Test
    @DisplayName("input 2 should return 2")
    void input2ShouldReturn2() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        String actual = fizzBuzz.fizzBuzz(2);

        assertEquals("2", actual);
    }
}
```

- `FizzBuzz.java`
```java
class FizzBuzz {
    String fizzBuzz(int input) {
        if (input == 2) {
            return "2";
        }
        return "1";
    }
}
```
