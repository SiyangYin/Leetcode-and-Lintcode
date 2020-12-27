public class Solution {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0), prev = dummy;
        dummy.next = head;
        
        while (true) {
            for (int i = 0; i < m && prev != null; i++) {
                prev = prev.next;
            }
            if (prev == null) {
                break;
            }
            
            ListNode forward = prev;
            for (int i = 0; i < n && forward != null; i++) {
                forward = forward.next;
            }
            if (forward == null) {
                prev.next = null;
                break;
            }
            
            prev.next = forward.next;
        }
        
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    
    public ListNode(int val) {
        this.val = val;
    }
}