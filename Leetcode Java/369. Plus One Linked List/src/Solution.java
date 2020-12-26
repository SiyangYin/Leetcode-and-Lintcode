public class Solution {
    public ListNode plusOne(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode newHead = reverse(head), dummy = new ListNode(0), prev = dummy;
        dummy.next = newHead;
        prev.next.val += 1;
        int carry = 0;
        while (prev.next != null) {
            prev.next.val += carry;
            carry = prev.next.val / 10;
            prev.next.val %= 10;
            
            prev = prev.next;
        }
    
        if (carry == 1) {
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
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(9);
        
        ListNode node = new Solution().plusOne(head);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
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