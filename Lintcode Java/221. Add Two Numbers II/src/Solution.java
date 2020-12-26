public class Solution {
    /**
     * @param l1: The first list.
     * @param l2: The second list.
     * @return: the sum list of l1 and l2.
     */
    public ListNode addLists2(ListNode l1, ListNode l2) {
        // write your code here
        return reverse(add(reverse(l1), reverse(l2)));
    }
    
    private ListNode add(ListNode l1, ListNode l2) {
        int cur = 0;
        ListNode dummy = new ListNode(0), prev = dummy;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                cur += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                cur += l2.val;
                l2 = l2.next;
            }
            prev.next = new ListNode(cur % 10);
            prev = prev.next;
            cur /= 10;
        }
        
        prev.next = cur == 1 ? new ListNode(1) : null;
        
        return dummy.next;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode res = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = res;
            res = head;
            head = tmp;
        }
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}