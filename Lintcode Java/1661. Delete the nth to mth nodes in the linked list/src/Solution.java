public class Solution {
    /**
     * @param head: The first node of linked list
     * @param n: the start index
     * @param m: the end node
     * @return: A ListNode
     */
    public ListNode deleteNode(ListNode head, int n, int m) {
        // Write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode first = head, second = head;
        int i = n, j = m - n + 1;
        while (i-- != 0) {
            first = first.next;
            second = second.next;
        }
        while (j-- != 0) {
            second = second.next;
        }
        first.next = second.next;
        return head.next;
    }
    
    
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}