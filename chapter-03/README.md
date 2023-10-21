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

### 3.2.1. Basic Implementation: Calculator

#### Walkthrough project structure

- `src/main/java`
- `src/test/java`
- `build.gradle`
  - `testImplementation`
  - `junit`

#### Create these files

- `Calculator.java`
- `CalculatorTest.java`

#### Example 3.2.1.1: Function `add`

```java
package com.werockstar.chapter03;

class Calculator {

    int add(int a, int b) {
        return a + b;
    }

}
```

#### Example 3.2.1.2: Test Code

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

### 3.2.2.1 Namming the Test

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

#### Example 3.2.2.2: Function `subtract`

```java
package com.werockstar.chapter03;

class Calculator {

    int subtract(int a, int b) {
        return a - b;
    }
}
```

```java
package com.werockstar.chapter03;

class CalculatorTest {

    @Test
    void given_2_subtract_1_should_return_minus_1() {
        Calculator calculator = new Calculator();
        
        int result = calculator.subtract(2, 1);
        
        assertEquals(1, result);
    }
}
```
