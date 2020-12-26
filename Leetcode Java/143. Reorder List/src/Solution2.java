import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(0);
        Deque<ListNode> deque = new ArrayDeque<>();
        while (head != null) {
            deque.offerLast(head);
            head = head.next;
        }
        
        ListNode cur = dummy;
        boolean first = true;
        while (!deque.isEmpty()) {
            if (first) {
                cur.next = deque.pollFirst();
            } else {
                cur.next = deque.pollLast();
            }
            first = !first;
            cur = cur.next;
        }
        cur.next = null;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        new Solution2().reorderList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
