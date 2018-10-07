package leetcode_120_140;

public class LRUCache {
	private int capacity;
	private int size;
	private Entry head;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.size = 0;

		this.head = null;
	}

	public int get(int key) {
		Entry e = this.head;
		while (e != null) {
			if (e.key == key) {
				updateAfterGet(key);
				return e.value;
			}
			e = e.next;
		}

		return -1;
	}

	public void put(int key, int value) {
		if (this.capacity == 0) {
			return;
		}

		if (get(key) != -1) {
			replace(key, value);
			return;
		}
		insertFromHead(key, value);

		if (size > capacity) {
			evict();
		}
	}

	private void insertFromHead(int key, int value) {
		if (head == null) {
			this.head = new Entry(key, value, null);
		} else {
			head = new Entry(key, value, this.head);
		}
		size++;
	}

	private void replace(int key, int value) {
		Entry e = this.head;
		while (e != null) {
			if (e.key == key) {
				e.value = value;
			}
			e = e.next;
		}
	}

	private void updateAfterGet(int key) {
		Entry e = this.head;
		if (e.key == key) {
			return;
		}
		int val;
		while (e.next != null && e.next.key != key) {
			e = e.next;
		}
		if (e.next != null) {
			val = e.next.value;
			e.next = e.next.next;
			head = new Entry(key, val, this.head);
		}

	}

	protected void evict() {
		Entry e = this.head;
		int i = 0;

		while (i < capacity - 1) {
			e = e.next;
			i++;
		}

		if (e != null) {
			e.next = null;
		}
		size = capacity;
	}


	private static class Entry {
		int key;
		int value;
		Entry next;

		public Entry(int key, int value) {
			this.key = key;
			this.value = value;
		}

		public Entry(int key, int value, Entry next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
}
