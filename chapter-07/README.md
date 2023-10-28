# Chapter 8: Refactoring #1

## Step 1: Long Parameter List

- `LongParameterList.java`

```java
public class LongParameterList {
    void print(
            String documentToPrint,
            String paperSize,
            String orientation,
            boolean grayScales,
            int pageFrom,
            int pageTo,
            int copies,
            float marginLeft,
            float marginRight,
            float marginTop,
            float marginBottom) {
    }
}
```

- Refactored `LongParameterList.java`
```java
public class LongParameterList {
    void refactoredPrint(
            PaperSize papersize,
            PrintOrientation orientation,
            ColorConfiguration color,
            PrintRange range,
            PrintMargins margins,
            int copiesCount
    ) {
    }
}

final class PaperSize {
}

final class Document {
}

final class PrintMargins {
}

final class PrintRange {
}

final class ColorConfiguration {
}

final class PrintOrientation {
}
```

## Step 2: Data Clumps
- `DataClumps.java`

```java
public class DataClump {
    void invoiceIn(LocalDate start, LocalDate end) {
    }

    void receivedIn(LocalDate start, LocalDate end) {
    }

    void overdueIn(LocalDate start, LocalDate end) {
    }
}
```

- Refactored `DataClumps.java`

```java
class Refactored {
    void invoiceIn(DateRange range) {
    }

    void receivedIn(DateRange range) {
    }

    void overdueIn(DateRange range) {
    }
}

record DateRange(LocalDate start, LocalDate end) {
}
```

## Step 3: Code Duplication

- `CodeDuplication.java`

```java
public class CodeDuplication {
    public void create() {
        Product iPhone = new Product();
        iPhone.setName("iPhone 15");
        iPhone.setPrice(10000);

        Product book = new Product();
        book.setName("Clean Code");
        book.setPrice(500);

        Product apple = new Product();
        apple.setName("Apple");
        apple.setPrice(10);
    }
}

class Product {
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
```

- Refactored `CodeDuplication.java`

```java
public class CodeDuplication {
    public void create() {
        Product iPhone = new Product("iPhone 15", 10000);
        Product book = new Product("Clean Code", 500);
        Product apple = new Product("Apple", 10);
    }
}

class Product {
    
    static Product create(String name, int price) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        return product;
    }
}
```

## Read more
- [Refactoring: Improving the Design of Existing Code](https://www.amazon.com/Refactoring-Improving-Existing-Addison-Wesley-Signature-dp-0134757599/dp/0134757599)
