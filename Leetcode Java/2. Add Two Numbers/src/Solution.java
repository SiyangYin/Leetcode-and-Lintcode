public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int t = 0;
        while (l1 != null || l2 != null || t != 0) {
            if (l1 != null) {
                t += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                t += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(t % 10);
            cur = cur.next;
            t /= 10;
        }
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
        int[] n1 = {2, 4, 6};
        int[] n2 = {5, 6, 4};
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
