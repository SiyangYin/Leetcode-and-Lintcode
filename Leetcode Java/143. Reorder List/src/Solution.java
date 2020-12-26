public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        
        ListNode secondLast = findBeforeLast(head);
        secondLast.next.next = head.next;
        head.next = secondLast.next;
        secondLast.next = null;
        reorderList(head.next.next);
    }
    
    private ListNode findBeforeLast(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        while (head.next.next != null) {
            head = head.next;
        }
        return head;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        // head.next.next = new ListNode(3);
        // head.next.next.next = new ListNode(4);
        // head.next.next.next.next = new ListNode(5);
        
        new Solution().reorderList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
