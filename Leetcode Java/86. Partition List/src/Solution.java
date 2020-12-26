public class Solution {
    
    public ListNode partition(ListNode head, int x) {
        // if (head == null) {
        //     return head;
        // }
        
        ListNode l1 = new ListNode(0), l2 = new ListNode(0);
        ListNode less = l1, more = l2;
        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = head;
            } else {
                more.next = head;
                more = head;
            }
            
            head = head.next;
        }
        
        more.next = null;
        less.next = l2.next;
        return l1.next;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        // head.next.next.next.next = new ListNode(5);
        // head.next.next.next.next.next = new ListNode(2);
        
        head = null;
        head = new Solution().partition(head, 3);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
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
