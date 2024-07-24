import java.util.Objects;

public class Product {
    private final int key;
    private final String name;
    private final int price;

    public Product(int key, String name, int price) {
        this.key = key;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        int key = ((Product)obj).key;
        String name = ((Product)obj).name;
        int price = ((Product)obj).price;
        if (this.key == key && this.name.equals(name) && this.price == price) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, name, price);
    }
}
