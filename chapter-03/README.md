# Chapter 3: Unit Testing: Concepts and Implementations

## 3.1. Introduction

### What's Unit?

- Structure
- Behavior

## 3.2 Basic Implementation

- `jUnit5`
- `@Test`
- Arrange, Act, Assert (AAA)
  - Arrange: initial context, set up the test
  - Act: execute the code being tested
  - Assert: verify behavior and results that we're expecting
- `@DisplayName`
- `@Disabled`
- `@BeforeEach`
- `@AfterEach`
- `@BeforeAll`
- `@AfterAll`
- `@Nested`

## Calculator

### 3.2.1. Basic Implementation: Calculator

#### Step 1: Walkthrough project structure

- `src/main/java`
- `src/test/java`
- `build.gradle`
  - `testImplementation`
  - `junit`

#### Step 2: Create these files

- `Calculator.java`
- `CalculatorTest.java`

#### Example 3.2.1.1: Function `add`

```java
package com.werockstar.chapter03;

class Calculator {

    int add(int leftOperand, int rightOperand) {
        return leftOperand + rightOperand;
    }

}
```

##### Step 3: Arrange, Act, Assert (AAA)

```java
package com.werockstar.chapter03;

class CalculatorTest {

    @Test
    void addShouldReturn3() {
        Calculator calculator = new Calculator();
        
        int result = calculator.add(1, 2);
        
        assertEquals(3, result);
    }
}
```

##### Step 4: How to Run?

- Function-level
- Class-level
- Package-level
- `./gradlew test`

### 3.2.2.1 Namming the Test

#### Steps 1: Revise Namming Test Method

- testAdd -> `given1Add2ShouldReturn3`
- addShouldReturn3 -> `given_1_add_2_should_return_3`
- addShouldReturn3 -> `whenAdd1and2ShouldReturn3`

```java
package com.werockstar.chapter03;

class CalculatorTest {

    @Test
    void given_1_add_2_should_return_3() {
        Calculator calculator = new Calculator();
        
        int result = calculator.add(1, 2);
        
        assertEquals(3, result);
    }
}
```

#### Steps 2: Using `@DisplayName`

```java
package com.werockstar.chapter03;

class CalculatorTest {

    @Test
    @DisplayName("1 + 2 = 3")
    void addShouldReturn3() {
        Calculator calculator = new Calculator();
        
        int result = calculator.add(1, 2);
        
        assertEquals(3, result);
    }
}
```

#### Example 3.2.2.2: Function `subtract`

```java
package com.werockstar.chapter03;

class Calculator {

    int subtract(int leftOperand, int rightOperand) {
        return leftOperand - rightOperand;
    }
}
```

```java
package com.werockstar.chapter03;

class CalculatorTest {

    @Test
    void given_2_subtract_1_should_return_1() {
        Calculator calculator = new Calculator();
        
        int result = calculator.subtract(2, 1);
        
        assertEquals(1, result);
    }
}
```

#### Example 3.2.2.3: Function `subtract` with Parameterized Test

```java
package com.werockstar.chapter03;

class CalculatorTest {

    @Test
    void given_2_subtract_2_should_return_0() {
        Calculator calculator = new Calculator();
        
        int result = calculator.subtract(2, 2);
        
        assertEquals(0, result);
    }

    @Test
    void given_3_subtract_3_should_return_0() {
        Calculator calculator = new Calculator();
        
        int result = calculator.subtract(3, 3);
        
        assertEquals(0, result);
    }
}
```

#### Example 3.2.2.4: Parameterized Test

```java
package com.werockstar.chapter03;

class CalculatorTest {

    @ParameterizedTest
    @CsvSource({
       "2, 1, 1",
       "2, 2, 0",
       "3, 3, 0"
    })
    void subtract(int leftOperand, int rightOperand, int expected) {
        var calculator = new Calculator();
    
        int result = calculator.subtract(leftOperand, rightOperand);

        assertEquals(expected, result);
   }

}
```

#### Example 3.2.2.5: Using Setup and Teardown

```java
package com.werockstar.chapter03;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("1 + 1 = 2")
    void addShouldReturn2() {
        int result = calculator.add(1, 1);

        assertEquals(2, result);
    }

    @ParameterizedTest
    @CsvSource({"2, 1, 1", "2, 2, 0", "3, 3, 0"})
    void subtract(int leftOperand, int rightOperand, int expected) {
        int result = calculator.subtract(leftOperand, rightOperand);

        assertEquals(expected, result);
    }

}
```

## Testing with Exception

### Bookshelf

- Add book
- Fetch bools
- Find book
  - with `id`
  - with `title`

#### Step 1: Create `Bookshelf.java`

```java
public class Bookshelf {

    private List<Book> books = List.of();

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("books must not be null");
        }
        books = Stream.concat(books.stream(), Stream.of(book)).toList();
    }

    public Book findBookById(int id) {
        return books.stream()
            .filter(book -> book.id() == id)
            .findFirst()
            .orElseThrow(() -> new BookNotFoundException("book not found"));
    }

    public Book findBookByTitle(String title) {
        return books.stream()
            .filter(book -> book.title().equals(title))
            .findFirst()
            .orElseThrow(() -> new BookNotFoundException("book not found"));
    }
}
```

#### Step 2: Create `Book.java` and `BookNotFoundException.java`

```java
public record Book(int id, String title) {
}

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }
}
```

#### Step 3: Create `BookshelfTest.java`

```java
class BookshelfTest {

    @Test
    @DisplayName("add clean code book to bookshelf and bookshelf should contain clean code book")
    void addCleanCodeBook() {
        var bookshelf = new Bookshelf();

        bookshelf.addBook(new Book(1, "Clean Code"));

        assertEquals("Clean Code", bookshelf.findBookById(1).title());
    }

    @Test
    @DisplayName("given bookshelf empty should throw BookNotFoundException")
    void findBookById1InEmptyBookshelf() {
        var bookshelf = new Bookshelf();

        assertThrows(BookNotFoundException.class, () -> bookshelf.findBookById(1));
    }

    @Test
    @DisplayName("given bookshelf empty should throw    BookNotFoundException with message book not found")
    void findBookById1InEmptyBookshelfExceptionShouldBeBookNotFound() {
        var bookshelf = new Bookshelf();    
    
        var exception = assertThrows(BookNotFoundException.class, ()    -> bookshelf.findBookById(1));    
        
        assertEquals("book not found", exception.getMessage());
    }
}
```
