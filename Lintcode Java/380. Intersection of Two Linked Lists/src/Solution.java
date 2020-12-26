public class Solution {
    /**
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // write your code here
        if (headA == null || headB == null) {
            return null;
        }
        ListNode cur = headA;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = headA;
        return hasCycle(headB);
    }
    
    private ListNode hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        
        ListNode slow = head, fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == null || fast.next == null) {
                return null;
            }
        } while (slow != fast);
        
        ListNode x = head;
        while (x != slow) {
            x = x.next;
            slow = slow.next;
        }
        return x;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}