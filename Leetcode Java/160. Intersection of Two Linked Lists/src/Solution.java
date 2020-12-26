public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0, len2 = 0;
        ListNode l1 = headA, l2 = headB;
        while (l1 != null) {
            len1++;
            l1 = l1.next;
        }
        
        while (l2 != null) {
            len2++;
            l2 = l2.next;
        }
        
        l1 = headA;
        l2 = headB;
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                l1 = l1.next;
            }
        } else if (len1 < len2) {
            for (int i = 0; i < len2 - len1; i++) {
                l2 = l2.next;
            }
        }
        
        while (l1 != l2 && l1 != null && l2 != null) {
            l1 = l1.next;
            l2 = l2.next;
        }
        
        return l1;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}