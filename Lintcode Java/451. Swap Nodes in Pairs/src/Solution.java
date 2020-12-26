public class Solution {
    /**
     * @param head: a ListNode
     * @return: a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while ((prev = swapTwo(prev)) != null) {
        
        }
        
        return dummy.next;
    }
    
    private ListNode swapTwo(ListNode prev) {
        // prev -> n1 -> n2 -> tail
        if (prev.next == null || prev.next.next == null) {
            return null;
        }
        
        ListNode n1 = prev.next, n2 = prev.next.next;
        ListNode tail = n2.next;
        n1.next = tail;
        n2.next = n1;
        prev.next = n2;
        return n1;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}