public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (ListNode cur = dummy; cur != null && cur.next!= null; cur = cur.next.next) {
            if (cur.next.next != null) {
                ListNode tmp = cur.next.next;
                cur.next.next = tmp.next;
                tmp.next = cur.next;
                cur.next = tmp;
            }
        }
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        // head.next.next.next = new ListNode(4);
        
        ListNode res = new Solution().swapPairs(head);
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