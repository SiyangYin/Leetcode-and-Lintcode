public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: nothing
     */
    public void reorderList(ListNode head) {
        // write your code here
        if (head == null) {
            return;
        }
        ListNode mid = findMid(head);
        ListNode secondHalf = mid.next;
        mid.next = null;
        
        secondHalf = reverse(secondHalf);
        merge(head, secondHalf);
    }
    
    private ListNode findMid(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        
        return prev;
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), prev = dummy;
        boolean odd = true;
        while (l1 != null || l2 != null) {
            if (odd) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
            odd = !odd;
        }
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        new Solution().reorderList(head);
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