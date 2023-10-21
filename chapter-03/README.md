# Chapter 3: Unit Testing: Concepts and Implementations

## 3.1. Introduction

### What's Unit?

- Structure
- Behavior

## 3.2 Basic Implementation

- `jUnit5`
- `@Test`
- Arrange, Act, Assert (AAA)
  - Arrange: set up the test
  - Act: execute the test
  - Assert: verify behavior and results that we're expecting
- `@DisplayName`
- `@Disabled`
- `@BeforeEach`
- `@AfterEach`
- `@BeforeAll`
- `@AfterAll`
- `@Nested`

### 3.2.1. Basic Implementation: Calculator

- `Calculator.java`
- `CalculatorTest.java`

#### Example 3.2.1: Production Code

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

#### Example 3.2.1: Test Code

##### Arrange, Act, Assert (AAA)

```java
package com.werockstar.chapter03;

class CalculatorTest {

    @Test
    void testAdd() {
        Calculator calculator = new Calculator();
        
        int result = calculator.add(1, 2);
        
        assertEquals(3, result);
    }
}
```

#### Revise 1: Namming Test Method

- testAdd -> `given1Add2ShouldReturn3`
- testAdd -> `given_1_add_2_should_return_3`
- testAdd -> `whenAdd1and2ShouldReturn3`

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
