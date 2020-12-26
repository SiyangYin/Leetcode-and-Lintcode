public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = cur;
            cur = head;
            head = tmp;
        }
        
        return cur;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
