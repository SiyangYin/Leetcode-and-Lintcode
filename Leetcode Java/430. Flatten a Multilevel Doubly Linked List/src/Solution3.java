import java.util.ArrayDeque;
import java.util.Deque;

public class Solution3 {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        
        Node dummy = new Node(0);
        Node cur, prev = dummy;
        
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(head);
        
        while (!stack.isEmpty()) {
            cur = stack.pop();
            prev.next = cur;
            cur.prev = prev;
            
            if (cur.next != null) {
                stack.push(cur.next);
            }
            if (cur.child != null) {
                stack.push(cur.child);
                cur.child = null;
            }
            prev = cur;
        }
        
        dummy.next.prev = null;
        return dummy.next;
    }
    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.child = new Node(4);
        head.next.child.next = new Node(5);
        head.next.child.next.prev = head.next.child;
        new Solution3().flatten(head);
    
        System.out.println();
    }
}
