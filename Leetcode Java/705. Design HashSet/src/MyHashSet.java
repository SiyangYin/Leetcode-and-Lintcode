public class MyHashSet {
    class ListNode {
        int key;
        ListNode next;
        ListNode(int key) {
            this.key = key;
        }
    }
    
    ListNode[] listNodes;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        listNodes = new ListNode[13 * 17];
    }
    
    public void add(int key) {
        int pos = key % listNodes.length;
        ListNode prev = listNodes[pos];
        if (prev == null) {
            listNodes[pos] = new ListNode(key);
            return;
        }
        
        if (prev.key == key) {
            return;
        }
        
        while (prev.next != null && prev.next.key != key) {
            prev = prev.next;
        }
        
        if (prev.next == null) {
            prev.next = new ListNode(key);
        }
    }
    
    public void remove(int key) {
        int pos = key % listNodes.length;
        ListNode prev = listNodes[pos];
        if (prev == null) {
            return;
        }
        
        if (prev.key == key) {
            listNodes[pos] = prev.next;
        }
    
        while (prev.next != null && prev.next.key != key) {
            prev = prev.next;
        }
    
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int pos = key % listNodes.length;
        ListNode prev = listNodes[pos];
        if (prev == null) {
            return false;
        }
        
        if (prev.key == key) {
            return true;
        }
    
        while (prev.next != null && prev.next.key != key) {
            prev = prev.next;
        }
        
        return prev.next != null;
    }
}
