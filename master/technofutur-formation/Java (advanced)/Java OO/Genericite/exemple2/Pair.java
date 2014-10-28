package exemple2;

import java.io.Serializable;

public class Pair<K extends Serializable, V> {
	private K key;
	private V value;

	public Pair() { }
	
	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return this.key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return this.value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	public static class Item implements Serializable {
		
	}
	
	public static void main(String[] args) {
		Pair<Item, String> p = new Pair<Item, String>(new Item(), "5");
		
	}
}
