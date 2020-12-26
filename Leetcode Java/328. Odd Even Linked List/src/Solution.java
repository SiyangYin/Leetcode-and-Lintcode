public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode l1 = new ListNode(0), l2 = new ListNode(0);
        ListNode odd = l1, even = l2;
        boolean isOdd = true;
        while (head != null) {
            if (isOdd) {
                odd.next = head;
                odd = head;
            } else {
                even.next = head;
                even = head;
            }
            head = head.next;
            isOdd = !isOdd;
        }
        
        odd.next = l2.next;
        even.next = null;
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        // head.next.next.next.next = new ListNode(5);
        
        ListNode newHead = new Solution().oddEvenList(head);
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
    }
}
