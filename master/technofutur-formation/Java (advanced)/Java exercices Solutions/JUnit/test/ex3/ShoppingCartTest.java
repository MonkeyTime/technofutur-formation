package ex3;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShoppingCartTest {

    private ShoppingCart cart;
    private Product book1;

    @Before
    public void initializeTest() { 
        cart = new ShoppingCart();
        book1 = new Product("Pragmatic Unit Testing", 29.95);
        cart.addItem(book1);
    }

    @Test
    public void testEmpty() {
        cart.empty();
        assertEquals(0, cart.getItemCount());
        assertEquals(0.0, cart.getBalance(), 0.0);
    }

    @Test
    public void testAddItem() {
        Product book2 = new Product("Pragmatic Project Automation", 29.95);
        cart.addItem(book2);

        assertEquals(2, cart.getItemCount());

        double expectedBalance = book1.getPrice() + book2.getPrice();
        assertEquals(expectedBalance, cart.getBalance(), 0.0);
    }

    @Test
    public void testRemoveItem() throws ProductNotFoundException {
        cart.removeItem(book1);
        assertEquals(0, cart.getItemCount());
        assertEquals(0.0, cart.getBalance(), 0.0);
    }

    @Test
    public void testRemoveItemNotInCart() {
        try {
            Product book3 = new Product("Pragmatic Version Control", 29.95);
            cart.removeItem(book3);

            fail("Should raise a ProductNotFoundException");
        } catch (ProductNotFoundException expected) {
            // successful test
        }
    }
}
