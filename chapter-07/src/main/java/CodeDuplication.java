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
        apple.setPrice(100);
    }

    public void refactored() {
        Product iPhone = Product.create("iPhone 15", 10000);
        Product book = Product.create("Clean Code", 500);
        Product apple = Product.create("Apple", 50);
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

    static Product create(String name, int price) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        return product;
    }
}