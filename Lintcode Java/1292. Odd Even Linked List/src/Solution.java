import java.util.List;

public class Solution {
    /**
     * @param head: a singly linked list
     * @return: Modified linked list
     */
    public ListNode oddEvenList(ListNode head) {
        // write your code here
        ListNode l1 = new ListNode(0), l2 = new ListNode(0);
        ListNode prev1 = l1, prev2 = l2;
        boolean odd = true;
        while (head != null) {
            if (odd) {
                prev1.next = head;
                prev1 = prev1.next;
            } else {
                prev2.next = head;
                prev2 = prev2.next;
            }
            head = head.next;
            odd = !odd;
        }
        
        prev1.next = prev2.next = null;
        
        ListNode oddTail = l1;
        while (oddTail.next != null) {
            oddTail = oddTail.next;
        }
        
        oddTail.next = l2.next;
        
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