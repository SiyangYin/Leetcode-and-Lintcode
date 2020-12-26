public class Solution {
    /**
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        ListNode l1 = new ListNode(0), l2 = new ListNode(0);
        ListNode prev1 = l1, prev2 = l2;
        while (head != null) {
            if (head.val < x) {
                prev1.next = head;
                prev1 = prev1.next;
            } else {
                prev2.next = head;
                prev2 = prev2.next;
            }
            head = head.next;
        }
        
        prev1.next = prev2.next = null;
        prev1.next = l2.next;
        return l1.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}