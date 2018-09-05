package leetcode_170_200;

public class LRU<K, V> {

	private Node<K, V> head, tail;
	private int capacity;
	private int size;

	public LRU(int capacity) {
		this.size = 0;
		this.capacity = capacity;
		head = tail = null;
	}

	public void put(K k, V v) {
		//if the LRU is empty
		if (get(k) != null) {
			replace(new Node<>(k, v));
		}
		// if the LRU is full ,remove the eldest
		if (size == capacity) {
			removeEldestNode();
			insert(new Node<>(k, v));
		} else {
			insert(new Node<>(k, v));
			size++;
		}
	}

	public V get(K k) {
		Node<K, V> p = head;

		while (p != null) {
			if (p.key == k || p.key.equals(k)) {
				if (p != head) {
					remove(k);
					insert(new Node<>(p.key, p.value));
				}
				return p.value;
			}
			p = p.next;
		}

		return null;
	}

	private void replace(Node<K, V> node) {
		Node<K, V> p = head;
		while (p != null) {
			if (p.key == node.key || p.key.equals(node.key)) {
				p.value = node.value;
				return;
			}
			p = p.next;
		}
	}

	private void insert(Node<K, V> node) {
		if (head == tail && head == null) {
			head = node;
			tail = head;
		} else {
			node.next = head;
			head.pre = node;

			head = node;
		}
	}

	private void removeEldestNode() {
		if (tail != null) {
			tail = tail.pre;
			tail.next = null;
		}
	}

	private void remove(K k) {
		Node<K, V> p = head;
		while (p != null) {
			if (p.key == k || p.key.equals(k)) {
				if (p == head) {
					head = head.next;
					head.pre = null;
				} else if (p == tail) {
					tail = tail.pre;
					tail.next = null;
				} else {
					p.pre.next = p.next;
					p.next.pre = p.pre;
					p.pre = null;
					p.next = null;
				}
				return;
			}
			p = p.next;
		}
	}

	private static class Node<K, V> {
		K key;
		V value;
		Node<K, V> next;
		Node<K, V> pre;

		public Node(K k, V v) {
			this.key = k;
			this.value = v;
		}
	}
}
