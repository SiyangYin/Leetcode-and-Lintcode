import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    
    class Node {
        int key, val;
        Node prev, next;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    // map the value to the node
    private Map<Integer, Node> map;
    private int size, capacity;
    private Node dummy, last;
    
    /*
     * @param capacity: An integer
     */
    public LRUCache(int capacity) {
        // do intialization if necessary
        map = new HashMap<>();
        dummy = new Node(0, 0);
        this.capacity = capacity;
    }
    
    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (!map.containsKey(key)) {
            return -1;
        }
        
        Node node = map.get(key);
        if (node != last) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = last;
            last.next = node;
            last = node;
            last.next = null;
        }
        
        return node.val;
    }
    
    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (!map.containsKey(key)) {
            if (size == 0) {
                dummy.next = new Node(key, value);
                dummy.next.prev = dummy;
                last = dummy.next;
            } else {
                last.next = new Node(key, value);
                last.next.prev = last;
                last = last.next;
                
            }
            
            map.put(key, last);
            size++;
            
            if (size > capacity) {
                Node node = dummy.next;
                dummy.next = dummy.next.next;
                dummy.next.prev = dummy;
                
                map.remove(node.key);
                size--;
            }
        } else {
            Node node = map.get(key);
            if (node != last) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.prev = last;
                last.next = node;
                last = node;
                last.next = null;
            }
            node.val = value;
        }
    }
    
    public static void main(String[] args) {
        // LRUCache cache = new LRUCache(2);
        // cache.set(2,1);
        // cache.set(1,1);
        // System.out.println(cache.get(2));
        //
        // cache.set(4, 1);
        // System.out.println(cache.get(1));
        //
        // System.out.println(cache.get(2));
        
        LRUCache cache = new LRUCache(1);
        cache.set(2, 1);
        System.out.println(cache.get(2));
        cache.set(3, 2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }
}
    