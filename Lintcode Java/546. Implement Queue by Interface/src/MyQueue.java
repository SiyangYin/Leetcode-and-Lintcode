interface InterfaceQueue {
    void push(int element);
    
    // define an interface for pop method
    /* write your code here */
    int pop();
    
    // define an interface for top method
    /* write your code here */
    int top();
}

public class MyQueue implements InterfaceQueue {
    
    class Node {
        int val;
        Node prev, next;
    
        public Node(int val) {
            this.val = val;
        }
    }
    
    private Node head, tail;
    private int size;
    
    /* you can declare your private attributes here */
    public MyQueue() {
        // do initialization if necessary
    }
    
    // implement the push method
    /* write your code here */
    @Override
    public void push(int val) {
        if (size == 0) {
            head = tail = new Node(val);
        } else {
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        size++;
    }
    
    // implement the pop method
    /* write your code here */
    @Override
    public int pop() {
        int res = head.val;
        head = head.next;
        size--;
        
        return res;
    }
    
    // implement the top method
    /* write your code here */
    @Override
    public int top() {
        return head.val;
    }
}