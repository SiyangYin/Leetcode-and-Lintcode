public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        ListNode dummy = new ListNode(0);
        while (head != null) {
            head = insert(dummy, head);
        }
        
        return dummy.next;
    }
    
    private ListNode insert(ListNode dummy, ListNode cur) {
        ListNode prev = dummy;
        while (prev.next != null && prev.next.val < cur.val) {
            prev = prev.next;
        }
        ListNode tmp = cur.next;
        cur.next = prev.next;
        prev.next = cur;
        return tmp;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode (int x) {
        val = x;
    }
}