public class Solution1 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int cnt = 0;
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
            cnt++;
        }
        k %= cnt + 1;
        if (k == 0) return head;
        ListNode p1 = head;
        ListNode p2 = p1.next;
        for (int i = 0; i < cnt - k; i++) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p.next = head;
        p1.next = null;
        return p2;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new Solution1().rotateRight(head, 0);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

