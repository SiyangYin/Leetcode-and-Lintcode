public class Solution {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
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
        
        if (cur == 1) {
            prev.next = new ListNode(1);
        }
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(6);
        
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(2);
        
        ListNode res = new Solution().addLists(l1, l2);
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
