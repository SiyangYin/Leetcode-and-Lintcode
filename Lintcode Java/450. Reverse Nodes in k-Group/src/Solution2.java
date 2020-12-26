public class Solution2 {
    /**
     * @param head: a ListNode
     * @param k: An integer
     * @return: a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while ((prev = reverseK(prev, k)) != null) {
        
        }
        
        return dummy.next;
    }
    
    private ListNode reverseK(ListNode prev, int k) {
        // prev -> n1 -> n2 -> ... -> nk -> tail
        ListNode nk = prev;
        for (int i = 0; i < k; i++) {
            nk = nk.next;
            if (nk == null) {
                return null;
            }
        }
        
        ListNode tail = nk.next;
        nk.next = null;
        ListNode n1 = prev.next;
        prev.next = reverse(prev.next);
        n1.next = tail;
        return n1;
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
