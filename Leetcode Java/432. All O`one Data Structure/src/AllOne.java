import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOne {
    
    class Node {
        Node prev, next;
        Set<String> keys;
        int cnt;
        
        public Node(String key, int cnt) {
            keys = new HashSet<>();
            keys.add(key);
            this.cnt = cnt;
        }
    }
    
    class LinkedList {
        Node head, tail;
        int size;
        
        public LinkedList() {
            head = new Node("", 0);
            tail = new Node("", 0);
            head.next = tail;
            tail.prev = head;
        }
        
        public void addFirst(Node node) {
            addAfter(head, node);
        }
        
        public void addAfter(Node cur, Node node) {
            node.prev = cur;
            node.next = cur.next;
            cur.next = node;
            node.next.prev = node;
            size++;
        }
        
        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        
        public boolean isEmpty() {
            return size == 0;
        }
    }
    
    private LinkedList linkedList;
    private Map<String, Node> map;
    
    /**
     * Initialize your data structure here.
     */
    public AllOne() {
        linkedList = new LinkedList();
        map = new HashMap<>();
    }
    
    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        if (!map.containsKey(key)) {
            if (linkedList.isEmpty() || linkedList.head.next.cnt != 1) {
                Node node = new Node(key, 1);
                linkedList.addFirst(node);
                map.put(key, node);
            } else {
                linkedList.head.next.keys.add(key);
                map.put(key, linkedList.head.next);
            }
        } else {
            Node node = map.get(key);
            node.keys.remove(key);
            if (node.next == linkedList.tail || node.next.cnt != node.cnt + 1) {
                linkedList.addAfter(node, new Node(key, node.cnt + 1));
            }
            map.put(key, node.next);
            node.next.keys.add(key);
            if (node.keys.isEmpty()) {
                linkedList.remove(node);
            }
        }
    }
    
    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        if (!map.containsKey(key)) {
            return;
        }
        
        Node node = map.get(key);
        node.keys.remove(key);
        if (node.cnt == 1) {
            map.remove(key);
        } else {
            if (node.prev == linkedList.head || node.prev.cnt != node.cnt - 1) {
                linkedList.addAfter(node.prev, new Node(key, node.cnt - 1));
            }
            node.prev.keys.add(key);
            map.put(key, node.prev);
        }
        
        if (node.keys.isEmpty()) {
            linkedList.remove(node);
        }
    }
    
    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        return linkedList.isEmpty() ? "" : linkedList.tail.prev.keys.iterator().next();
    }
    
    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        return linkedList.isEmpty() ? "" : linkedList.head.next.keys.iterator().next();
    }
    
    public static void main(String[] args) {
        AllOne cache = new AllOne();
        cache.inc("a");
        cache.inc("b");
        cache.inc("b");
        cache.inc("c");
        cache.inc("c");
        cache.inc("c");
        cache.dec("b");
        cache.dec("b");
        System.out.println("cache.getMinKey() = " + cache.getMinKey());
        cache.dec("a");
        System.out.println("cache.getMaxKey() = " + cache.getMaxKey());
        System.out.println("cache.getMinKey() = " + cache.getMinKey());
    }
}
