public class Solution {
    /**
     * @param head: the first Node
     * @return: the answer after plus one
     */
    public ListNode plusOne(ListNode head) {
        // Write your code here
        ListNode tmp = reverse(head);
        ListNode dummy = new ListNode(0), cur = dummy;
        dummy.next = tmp;
        int carry = 1;
        while (cur.next != null) {
            cur.next.val += carry;
            carry = cur.next.val / 10;
            cur.next.val %= 10;
            cur = cur.next;
        }
        
        if (carry == 1) {
            cur.next = new ListNode(1);
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
        head.next.next = new ListNode(3);
    
        ListNode res = new Solution().plusOne(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
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