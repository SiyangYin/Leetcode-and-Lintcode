public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while (head != null) {
            ListNode last = lastOne(head);
            if (head == last) {
                cur.next = head;
                cur = cur.next;
            }
            head = last.next;
        }
        cur.next = null;
        return dummy.next;
    }
    
    private ListNode lastOne(ListNode cur) {
        while (cur.next != null && cur.val == cur.next.val) {
            cur = cur.next;
        }
        return cur;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tmp = head;
        int[] vals = {1, 2, 3, 3, 4, 4, 5, 5};
        for (int val : vals) {
            head.next = new ListNode(val);
            head = head.next;
        }
        head = tmp;
        ListNode res = new Solution().deleteDuplicates(head);
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
