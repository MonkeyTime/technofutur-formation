package exemple1;

public class LinkedList<T> {
	private ListItem start = null;
	private ListItem end = null;
	private ListItem current = null;

	public LinkedList() {
	}

	public LinkedList(T item) {
		if (item != null) {
			this.current = this.end = this.start = new ListItem(item);
		}
	}

	public LinkedList(T[] items) {
		if (items != null) {
			for (int i = 0; i < items.length; i++) {
				addItem(items[i]);
			}
			current = start;
		}
	}

	public void addItem(T item) {
		ListItem newEnd = new ListItem(item);
		if (this.start == null) {
			this.start = this.end = newEnd;
		} else {
			this.end.next = newEnd;
			this.end = newEnd;
		}
	}

	public T getFirst() {
		this.current = this.start;
		return start == null ? null : start.item;
	}

	public T getNext() {
		if (this.current != null)
			this.current = this.current.next;
		return current == null ? null : this.current.item;
	}

	private class ListItem {
		T item;
		ListItem next = null;

		public ListItem(T item) {
			this.item = item;
		}

		@Override
		public String toString() {
			return "ListItem " + item;
		}
	}
}
