public class Solution {
    /**
     * @param head: a ListNode
     * @param k: An integer
     * @return: a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode cur = dummy;
        while (cur != null) {
            cur = reverseNextK(cur, k);
        }
        return dummy.next;
    }
    
    // head -> n1 -> n2 -> ... -> nk -> nk+1
    // =>
    // head -> nk -> nk-1 -> ... -> n1 -> nk+1
    // return nk+1
    private ListNode reverseNextK(ListNode head, int k) {
        ListNode test = head;
        ListNode n1 = head.next;
        for (int i = 0; i < k; i++) {
            test = test.next;
            if (test == null) {
                return null;
            }
        }
        
        // test -> nk
        ListNode nkplus = test.next;
        
        ListNode prev = null;
        ListNode cur = n1;
        // add cur before prev
        while (cur != nkplus) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        
        head.next = test;
        n1.next = nkplus;
        
        return n1;
    }
    
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        
        ListNode head = new Solution().reverseKGroup(n1, 3);
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
        next = null;
    }
}