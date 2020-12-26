public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode cur = dummy;
            while (cur.next != null && cur.next.val < head.val) {
                cur = cur.next;
            }
            ListNode tmp = head.next;
            head.next = cur.next;
            cur.next = head;
            head = tmp;
        }
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
    
        ListNode res = new Solution().insertionSortList(head);
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