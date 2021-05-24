public class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode n1 = head, n2 = head, fast = head;
        for (int i = 0; i < k - 1; i++) {
            n1 = n1.next;
            fast = fast.next;
        }
    
        while (fast.next != null) {
            fast = fast.next;
            n2 = n2.next;
        }
        
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
        
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    
    public ListNode(int val) {
        this.val = val;
    }
}