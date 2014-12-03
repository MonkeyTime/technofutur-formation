package ex3;

import java.util.*;

public class ShoppingCart {

    private ArrayList<Product> items;
    private double balance;

    public ShoppingCart() {
        items = new ArrayList<Product>();
    }

    public double getBalance() {
        return balance;
    }

    public void addItem(Product item) {
        if (item == null)
            throw new NullPointerException();
        
        items.add(item);
        balance += item.getPrice();
    }

    public void removeItem(Product item) throws ProductNotFoundException {
        if (!items.remove(item)) {
            throw new ProductNotFoundException();
        } else {
            balance -= item.getPrice();
        }
    }

    public int getItemCount() {
        return items.size();
    }

    public void empty() {
        items.clear();
        balance = 0.0;
    }
}
