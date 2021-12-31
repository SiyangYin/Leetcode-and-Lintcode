import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    
    private static class Node {
        Node prev, next;
        int key, val;
    
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    private Map<Integer, Node> map;
    private int size, capacity;
    private Node first, last;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        first = new Node(0, 0);
        last = new Node(0, 0);
        first.next = last;
        last.prev = first;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
    
        Node node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = last.prev;
        node.next = last;
        node.prev.next = node.next.prev = node;
        return node.val;
    }
    
    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            Node node = new Node(key, value);
            node.prev = last.prev;
            node.next = last;
            node.prev.next = node.next.prev = node;
            map.put(key, node);
            
            size++;
            if (size > capacity) {
                map.remove(first.next.key);
                first.next = first.next.next;
                first.next.prev = first;
                size--;
            }
        } else {
            Node node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = last.prev;
            node.next = last;
            node.prev.next = node.next.prev = node;
            node.val = value;
        }
    }
}
