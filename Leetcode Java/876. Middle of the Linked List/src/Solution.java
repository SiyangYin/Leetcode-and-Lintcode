public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        if (head == null) {
            return null;
        }
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if (fast.next == null) {
            return slow;
        } else {
            return slow.next;
        }
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        // head.next.next.next.next = new ListNode(5);
    
        System.out.println(new Solution().middleNode(head).val);
    
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}