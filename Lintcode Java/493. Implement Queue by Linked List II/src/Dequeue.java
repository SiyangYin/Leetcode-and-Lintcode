import java.util.LinkedList;

public class Dequeue {
    
    class ListNode {
        int val;
        ListNode prev, next;
        
        ListNode(int val) {
            this.val = val;
        }
    }
    
    private ListNode head, tail;
    private int size;
    
    public Dequeue() {
        // do intialization if necessary
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
    }
    
    /*
     * @param item: An integer
     * @return: nothing
     */
    public void push_front(int item) {
        // write your code here
        ListNode node = new ListNode(item);
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
        size++;
    }
    
    /*
     * @param item: An integer
     * @return: nothing
     */
    public void push_back(int item) {
        // write your code here
        ListNode node = new ListNode(item);
        node.prev = tail.prev;
        node.prev.next = node;
        node.next = tail;
        tail.prev = node;
        size++;
    }
    
    /*
     * @return: An integer
     */
    public int pop_front() {
        // write your code here
        int res = head.next.val;
        head = head.next;
        head.prev = null;
        size--;
        
        return res;
    }
    
    /*
     * @return: An integer
     */
    public int pop_back() {
        // write your code here
        int res = tail.prev.val;
        tail = tail.prev;
        tail.next = null;
        size--;
        return res;
    }
    
    public static void main(String[] args) {
        Dequeue dequeue = new Dequeue();
        dequeue.push_front(204);
        dequeue.pop_front();
        dequeue.push_front(24);
        dequeue.push_back(138);
        dequeue.pop_back();
        dequeue.pop_front();
        dequeue.push_front(209);
        dequeue.pop_front();
        dequeue.push_front(860);
        dequeue.push_front(313);
        
    }
}