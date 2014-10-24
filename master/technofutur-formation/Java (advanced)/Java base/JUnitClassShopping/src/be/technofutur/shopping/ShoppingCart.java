package be.technofutur.shopping;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

	protected Map<Integer, Product> cart = new HashMap<Integer, Product>();
	protected double total;

	/**
	 * Constructor
	 */
	protected ShoppingCart() {}
	
	/**
	 * 
	 * @return
	 */
	public ShoppingCart getInstance() {
		
		total = 0;
		
		return new ShoppingCart();
	}
	
	/**
	 * 
	 * @param product
	 */
	public void addProduct(Product product) {
		
		this.cart.put(product.id, product);
	}
	
	/**
	 * 
	 * @param product
	 */
	public void removeProduct(Product product) {
		
		this.cart.remove(product.id, product);
	}
	
	/**
	 * 
	 * @return
	 */
	public double getTotal() {
		
		for(int i = 0; i < this.cart.size(); i++) {
			
			this.total += this.cart.get(i).price;
		}
		
		return this.total;
	}

	/**
	 * 
	 */
	public void flushCart() {
		
		cart.clear();
	}
}
