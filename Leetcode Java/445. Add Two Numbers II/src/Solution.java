public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), prev = dummy;
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        int cur = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                cur += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                cur += l2.val;
                l2 = l2.next;
            }
            
            prev.next = new ListNode(cur % 10);
            prev = prev.next;
            cur /= 10;
        }
        
        if (cur == 1) {
            prev.next = new ListNode(1);
        }
        
        return reverse(dummy.next);
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        
        return prev;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
