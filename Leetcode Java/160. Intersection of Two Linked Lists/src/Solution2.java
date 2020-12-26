public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
    
        ListNode cur = headA;
        while (cur.next != null) {
            cur = cur.next;
        }
    
        cur.next = headB;
    
        ListNode slow = headA, fast = headA;
    
        do {
            slow = slow.next;
            if (slow == null || fast == null || fast.next == null) {
                return null;
            }
        
            fast = fast.next.next;
        } while (slow != fast);
    
        slow = headA;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
    
        return slow;
    }
}
