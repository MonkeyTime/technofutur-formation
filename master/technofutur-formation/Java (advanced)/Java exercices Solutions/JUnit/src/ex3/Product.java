package ex3;

public class Product {

    private String title;
    private double price;

    public Product(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object that) {
        if (that == null) {
            return false;
        }

        if (that == this) {
            return true;
        }

        if (that instanceof Product) {
            Product p = (Product) that;
            String thatTitle = p.getTitle();

            if (thatTitle == null) {
                return title == null;
            } else {
                return p.getTitle().equals(title);
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }
}
