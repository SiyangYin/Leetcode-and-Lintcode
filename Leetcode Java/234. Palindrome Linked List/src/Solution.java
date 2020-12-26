public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode slow = dummy, fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode h2 = slow.next;
        slow.next = null;
        h2 = reverse(h2);
        return compare(dummy.next, h2);
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
    
    private boolean compare(ListNode h1, ListNode h2) {
        //  assert h1's length - h2's length is 0 or 1
        if (h1 == null && h2 == null) {
            return true;
        }
    
        while (h1 != null && h2 != null) {
            if (h1.val != h2.val) {
                return false;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
    
        System.out.println(new Solution().isPalindrome(head));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}