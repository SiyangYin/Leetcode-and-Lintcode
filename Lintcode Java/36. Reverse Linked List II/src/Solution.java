public class Solution {
    /**
     * @param head: ListNode head is the head of the linked list
     * @param m: An integer
     * @param n: An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, after = null;
        ListNode first = dummy, tail = null;
        first = first.next;
        for (int i = 0; i < m - 1; i++) {
            first = first.next;
            prev = prev.next;
        }
        
        after = first;
        for (int i = 0; i < n - m; i++) {
            after = after.next;
        }
        tail = after;
        after = after.next;
        tail.next = null;
        
        prev.next = reverse(first);
        first.next = after;
        
        return dummy.next;
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
}