package LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
	private final int capacity;
	private final Map<K, Node<K, V>> map;
	private final DoublyLinkedList<K, V> dll;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<>();
		this.dll = new DoublyLinkedList<K, V>();
	}

	public synchronized V get(K key) {
		if (!map.containsKey(key))
			return null;
		Node<K, V> node = map.get(key);
		dll.moveToFront(node);
		return node.value;
	}

	public synchronized void put(K key, V value) {
		if (map.containsKey(key)) {
			Node<K, V> node = map.get(key);
			node.value = value;
			dll.moveToFront(node);
		} else {
			if (map.size() == capacity) {
				Node<K, V> del = dll.removeLast();
				map.remove(del.key);
			}
			Node<K, V> node = new Node<K, V>(key, value);
			dll.addFirst(node);
			map.put(key, node);
		}
	}

	public synchronized void remove(K key) {
		if (!map.containsKey(key))
			return;
		Node<K, V> node = map.get(key);
		dll.remove(node);
		map.remove(key);
	}
}
