public class Solution {
    /**
     * @param head: a ListNode
     * @param v1: An integer
     * @param v2: An integer
     * @return: a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l1, l2;
        l1 = l2 = dummy;
        
        while (l1.next != null && l1.next.val != v1) {
            l1 = l1.next;
        }
        while (l2.next != null && l2.next.val != v2) {
            l2 = l2.next;
        }
        
        if (l1.next == null || l2.next == null) {
            return head;
        }
        
        if (l1.next != l2 && l2.next != l1) {
            ListNode n1 = l1.next.next, n2 = l2.next.next;
            // l1 -> v1 -> n1 -> ... -> l2 -> v2 -> n2
            l1.next.next = n2;
            l2.next.next = n1;
            ListNode vv2 = l2.next;
            l2.next = l1.next;
            l1.next = vv2;
        } else {
            if (l1.next != l2) {
                ListNode tmp = l1;
                l1 = l2;
                l2 = tmp;
            }
            // l1 -> v1 == l2 -> v2 -> n2
            ListNode vv2 = l2.next;
            l1.next.next = vv2.next;
            vv2.next = l1.next;
            l1.next = vv2;
        }
        
        return dummy.next;
        
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = new Solution().swapNodes(head, 3, 4);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
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