class MyLinkedList {
    
    ListNode head, tail;
    int size;
    
    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
    
    }
    
    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (!checkIndex(index)) {
            return -1;
        }
        
        return getNode(index).val;
    }
    
    /**
     * Add a node of value val before the first element of the linked list.
     * After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        if (size == 0) {
            head = tail = new ListNode(val);
        } else {
            head = new ListNode(val, null, head);
            head.next.prev = head;
        }
        
        size++;
    }
    
    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (size == 0) {
            head = tail = new ListNode(val);
        } else {
            tail = new ListNode(val, tail, null);
            tail.prev.next = tail;
        }
        
        size++;
    }
    
    /**
     * Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
    
        ListNode node = getNode(index);
        ListNode insert = new ListNode(val, node.prev, node);
        node.prev.next = insert;
        node.prev = insert;
        size++;
    }
    
    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (!checkIndex(index)) {
            return;
        }
    
        if (size == 1) {
            head = tail = null;
            size--;
            return;
        }
        
        ListNode node = getNode(index);
        if (node == head) {
            head = head.next;
        } else if (node == tail) {
            tail = tail.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        
        size--;
    }
    
    private ListNode getNode(int index) {
        int mid = size + 1 >> 1;
        ListNode cur = null;
        if (index < mid) {
            cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
        } else {
            cur = tail;
            for (int i = 0; i < size - index - 1; i++) {
                cur = cur.prev;
            }
        }
    
        return cur;
    }
    
    private boolean checkIndex(int index) {
        return index >= 0 && index < size;
    }
    
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtTail(2);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        
        list.deleteAtIndex(0);
        System.out.println(list.get(0));
    }
}

class ListNode {
    int val;
    ListNode prev, next;
    
    ListNode(int x) {
        val = x;
    }
    
    ListNode(int x, ListNode prev, ListNode next) {
        this.prev = prev;
        this.next = next;
        val = x;
    }
}