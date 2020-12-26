public class MyQueue {
    
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    
    private ListNode head, tail;
    
    /*
     * @param item: An integer
     * @return: nothing
     */
    public void enqueue(int item) {
        // write your code here
        if (head == null) {
            head = tail = new ListNode(item);
            return;
        } else {
            tail.next = new ListNode(item);
            tail = tail.next;
        }
    }
    
    /*
     * @return: An integer
     */
    public int dequeue() {
        // write your code here
        int res = head.val;
        head = head.next;
        return res;
    }
}