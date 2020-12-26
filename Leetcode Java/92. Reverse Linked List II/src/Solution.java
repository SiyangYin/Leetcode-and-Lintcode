public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0), prev = dummy;
        dummy.next = head;
        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
        }
        
        ListNode first = prev.next, last = first;
        ListNode newLast = first;
        for (int i = 0; i < n - m; i++) {
            last = last.next;
        }
        
        ListNode lastNext = last.next;
        last.next = null;
        ListNode newFirst = null;
        while (first != null) {
            ListNode tmp = first.next;
            first.next = newFirst;
            newFirst = first;
            first = tmp;
        }
        
        prev.next = newFirst;
        newLast.next = lastNext;
        
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}