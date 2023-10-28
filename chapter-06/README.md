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

## Step 4: Add input 3 return "Fizz"

- `FizzBuzzTest.java`

```java
class FizzBuzzTest {

    @Test
    @DisplayName("input 3 should return Fizz")
    void input3ShouldReturnFizz() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        String actual = fizzBuzz.fizzBuzz(3);

        assertEquals("Fizz", actual);
    }
}
```

- `FizzBuzz.java`

```java
class FizzBuzz {
    String fizzBuzz(int input) {
        if (input == 3) {
            return "Fizz";
        }
        if (input == 2) {
            return "2";
        }
        return "1";
    }
}
```

## Step 5: Add input 4 return "4"

- `FizzBuzzTest.java`

```java
class FizzBuzzTest {

    @Test
    @DisplayName("input 4 should return 4")
    void input4ShouldReturn4() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        String actual = fizzBuzz.fizzBuzz(4);

        assertEquals("4", actual);
    }
}
```

- `FizzBuzz.java`

```java
class FizzBuzz {
    String fizzBuzz(int input) {
        if (input == 4) {
            return "4";
        }
        if (input == 3) {
            return "Fizz";
        }
        if (input == 2) {
            return "2";
        }
        return "1";
    }
}
```

## Step 6: Refactoring after test pass

- `FizzBuzz.java`

```java
class FizzBuzz {
    String fizzBuzz(int input) {
        if (input == 3) {
            return "Fizz";
        }
        return number + "";
    }
}
```

## Step 7: Add input 5 return "Buzz"

- `FizzBuzzTest.java`

```java
class FizzBuzzTest {

    @Test
    @DisplayName("input 5 should return Buzz")
    void input5ShouldReturnBuzz() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        String actual = fizzBuzz.fizzBuzz(5);

        assertEquals("Buzz", actual);
    }
}
```

- `FizzBuzz.java`

```java
class FizzBuzz {
    String fizzBuzz(int input) {
        if (input == 5) {
            return "Buzz";
        }
        if (input == 3) {
            return "Fizz";
        }
        return number + "";
    }
}
```

## Step 8: Add input 6 return "Fizz"

- `FizzBuzzTest.java`

```java
class FizzBuzzTest {

    @Test
    @DisplayName("input 6 should return Fizz")
    void input6ShouldReturnFizz() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        String actual = fizzBuzz.fizzBuzz(6);

        assertEquals("Fizz", actual);
    }
}
```

- `FizzBuzz.java`

```java
class FizzBuzz {
    String fizzBuzz(int input) {
        if (input == 6) {
            return "Fizz";
        }
        if (input == 5) {
            return "Buzz";
        }
        if (input == 3) {
            return "Fizz";
        }
        return number + "";
    }
}
```

## Step 9: Add input 7 return "7"

- `FizzBuzzTest.java`

```java
class FizzBuzzTest {

    @Test
    @DisplayName("input 7 should return 7")
    void input7ShouldReturn7() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        String actual = fizzBuzz.fizzBuzz(7);

        assertEquals("7", actual);
    }
}
```

## Step 10: Pause and think about the test we added

## Step 11: Jumping to input 9

- `FizzBuzzTest.java`

```java
class FizzBuzzTest {

    @Test
    @DisplayName("input 9 should return Fizz")
    void input9ShouldReturnFizz() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        String actual = fizzBuzz.fizzBuzz(9);

        assertEquals("Fizz", actual);
    }
}
```

- `FizzBuzz.java`

```java
public class FizzBuzz {
    public String fizzBuzz(int number) {
        if (number == 9) {
            return "Fizz";
        }
        if (number == 6) {
            return "Fizz";
        }
        if (number == 5) {
            return "Buzz";
        }
        if (number == 3) {
            return "Fizz";
        }
        return number + "";
    }
}
```

## Step 12: Refactoring: make the code simpler #1

- `FizzBuzz.java`

```java
public class FizzBuzz {
    public String fizzBuzz(int number) {
        if (number == 9 || number == 6 || number == 3) {
            return "Fizz";
        }
        if (number == 5) {
            return "Buzz";
        }
        return number + "";
    }
}
```

## Step 13: Refactoring: make the code simpler#2

- `FizzBuzz.java`

```java
public class FizzBuzz {
    public String fizzBuzz(int number) {
        if (number % 3 == 0) {
            return "Fizz";
        }
        if (number == 5) {
            return "Buzz";
        }
        return number + "";
    }
}
```

## Step 14: Exercise

- Add input 10 return `"Buzz"`
- Remember: Refactoring after test pass
- Add input 15 return `"FizzBuzz"`