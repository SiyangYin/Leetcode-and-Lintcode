import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    
    class Node {
        int key, val, freq;
        Node prev, next;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            freq = 1;
        }
    }
    
    class LinkedList {
        Node head, tail;
        int size;
        
        public LinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }
        
        public void addFirst(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next = node;
            node.next.prev = node;
            size++;
        }
        
        public void remove(Node node) {
            if (size == 0) {
                return;
            }
            
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        
        public Node removeLast() {
            if (size == 0) {
                return null;
            }
            Node res = tail.prev;
            remove(res);
            return res;
        }
    }
    
    private Map<Integer, Node> nodeMap;
    private Map<Integer, LinkedList> freqMap;
    private int capacity, minFreq;
    
    public LFUCache(int capacity) {
        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();
        freqMap.put(1, new LinkedList());
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1;
        }
        
        Node node = nodeMap.get(key);
        update(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.val = value;
            update(node);
            return;
        }
        
        if (nodeMap.size() == capacity) {
            removeOldest();
        }
        
        Node node = new Node(key, value);
        nodeMap.put(key, node);
        freqMap.get(1).addFirst(node);
        minFreq = 1;
    }
    
    private void update(Node node) {
        LinkedList list = freqMap.get(node.freq);
        list.remove(node);
        if (node.freq == minFreq && list.size == 0) {
            minFreq++;
        }
        node.freq++;
        freqMap.putIfAbsent(node.freq, new LinkedList());
        freqMap.get(node.freq).addFirst(node);
    }
    
    private void removeOldest() {
        LinkedList list = freqMap.get(minFreq);
        Node node = list.removeLast();
        nodeMap.remove(node.key);
    }
    
    public static void main(String[] args) {
        // LFUCache cache = new LFUCache(2);
        // cache.put(1, 1);
        // cache.put(2, 2);
        // System.out.println("cache.get(1) = " + cache.get(1));
        // cache.put(3, 3);
        // System.out.println("cache.get(2) = " + cache.get(2));
        // System.out.println("cache.get(3) = " + cache.get(3));
        // cache.put(4, 4);
        // System.out.println("cache.get(1) = " + cache.get(1));
        // System.out.println("cache.get(3) = " + cache.get(3));
        // System.out.println("cache.get(4) = " + cache.get(4));
        LFUCache cache = new LFUCache(0);
        cache.put(0,0);
        System.out.println("cache.get(0) = " + cache.get(0));
    }
}
