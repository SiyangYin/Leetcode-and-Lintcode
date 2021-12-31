import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {
    
    class ListNode {
        int key, val;
        ListNode next;
        
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    private ListNode dummy, tail;
    private Map<Integer, ListNode> map;
    private int capacity;
    
    public LRUCache2(int capacity) {
        dummy = new ListNode(0, 0);
        tail = dummy;
        map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        ListNode prev = map.get(key);
        if (prev == null) {
            return -1;
        }
        
        tail.next = new ListNode(key, prev.next.val);
        map.put(key, tail);
        tail = tail.next;
        prev.next = prev.next.next;
        map.put(prev.next.key, prev);
        
        
        return tail.val;
    }
    
    public void put(int key, int value) {
        ListNode old = map.get(key);
        
        tail.next = new ListNode(key, value);
        
        map.put(key, tail);
        tail = tail.next;
        if (old != null) {
            old.next = old.next.next;
            map.put(old.next.key, old);
        }
        
        if (map.size() > capacity) {
            map.remove(dummy.next.key);
            dummy.next = dummy.next.next;
            map.put(dummy.next.key, dummy);
        }
    }
}

/**
 * Your LRUCache3 object will be instantiated and called as such:
 * LRUCache3 obj = new LRUCache3(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */