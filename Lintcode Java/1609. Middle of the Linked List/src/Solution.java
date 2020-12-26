public class Solution {
    /**
     * @param head: the head node
     * @return: the middle node
     */
    public ListNode middleNode(ListNode head) {
        // write your code here.
        ListNode dummy = new ListNode(0), slow = dummy, fast = dummy;
        dummy.next = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return fast == null ? slow : slow.next;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        
        ListNode newHead = new Solution().middleNode(head);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
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
