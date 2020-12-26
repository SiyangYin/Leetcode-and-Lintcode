public class Solution {
    /**
     * @param head: A ListNode.
     * @return: A boolean.
     */
    public boolean isPalindrome(ListNode head) {
        // write your code here
        ListNode dummy = new ListNode(0), slow, fast;
        dummy.next = head;
        slow = fast = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode l2 = slow.next;
        slow.next = null;
        return equal(head, reverse(l2));
    }
    
    private ListNode reverse(ListNode head) {
        ListNode res = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = res;
            res = head;
            head = tmp;
        }
        
        return res;
    }
    
    private boolean equal(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        
        return true;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}