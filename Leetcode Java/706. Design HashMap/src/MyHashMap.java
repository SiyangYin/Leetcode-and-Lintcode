public class MyHashMap {
    class ListNode {
        int key, val;
        ListNode next;
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    private ListNode[] listNodes;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        listNodes = new ListNode[200];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int pos = key % listNodes.length;
        ListNode prev = listNodes[pos];
        if (prev == null) {
            listNodes[pos] = new ListNode(key, value);
            return;
        }
        
        if (prev.key == key) {
            prev.val = value;
            return;
        }
        
        while (prev.next != null && prev.next.key != key) {
            prev = prev.next;
        }
        
        if (prev.next == null) {
            prev.next = new ListNode(key, value);
        } else {
            prev.next.val = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        ListNode prev = listNodes[key % listNodes.length];
        if (prev == null) {
            return -1;
        }
        
        if (prev.key == key) {
            return prev.val;
        }
        
        while (prev.next != null && prev.next.key != key) {
            prev = prev.next;
        }
        
        if (prev.next == null) {
            return -1;
        } else {
            return prev.next.val;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        ListNode prev = listNodes[key % listNodes.length];
        if (prev == null) {
            return;
        }
        
        if (prev.key == key) {
            listNodes[key % listNodes.length] = prev.next;
            return;
        }
    
        while (prev.next != null && prev.next.key != key) {
            prev = prev.next;
        }
    
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }
}
