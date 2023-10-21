# Chapter 3: Unit Testing: Concepts and Implementations

## 3.1. Introduction

### What's Unit?

- Structure
- Behavior

## 3.2 Basic Implementation

- jUnit5
- @Test
- Arrange, Act, Assert (AAA)
  - Arrange: set up the test
  - Act: execute the test
  - Assert: verify behavior and results that we're expecting
- @DisplayName
- @Disabled
- @BeforeEach
- @AfterEach
- @BeforeAll
- @AfterAll
- @Nested

### 3.2.1. Basic Implementation: Calculator

- Calculator.java
- CalculatorTest.java

#### Example: Production Code

```java
package com.werockstar.chapter03;

class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    int subtract(int a, int b) {
        return a - b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    int divide(int a, int b) {
        return a / b;
    }
}
```

#### Example: Test Code

```java
package com.werockstar.chapter03;

class CalculatorTest {

    @Test
    @DisplayName("Test add method")
    void testAdd() {
        Calculator calculator = new Calculator();
     
        int result = calculator.add(1, 2);
     
        assertEquals(3, result);
    }
}

```