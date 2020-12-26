public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        int len = 0;
        while (prev.next != null) {
            len++;
            prev = prev.next;
        }
        
        k %= len;
        prev = dummy;
        for (int i = 0; i < len - k; i++) {
            prev = prev.next;
        }
     
        ListNode tail = prev;
        while (tail.next != null) {
            tail = tail.next;
        }
        
        tail.next = head;
        head = prev.next;
        prev.next = null;
        
        return head;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new Solution().rotateRight(head, 0);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}