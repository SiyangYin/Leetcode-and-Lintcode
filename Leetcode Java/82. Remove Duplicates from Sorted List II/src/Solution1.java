public class Solution1 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p1 = head;
        ListNode p2 = p1.next;
        if (p1.val == p2.val) {
            while (p2 != null && (p1.val == p2.val || p2.next != null && p2.val == p2.next.val)) {
                p1 = p1.next;
                p2 = p2.next;
            }
            head = p1 == null ? null : p1.next;
        }
        while (p2 != null && p2.next != null) {
            while (p2.next != null && p2.val != p2.next.val) {
                p1 = p1.next;
                p2 = p2.next;
            }
            if (p2.next != null && p2.val == p2.next.val) {
                while (p2.next != null && p2.val == p2.next.val) {
                    p2 = p2.next;
                }
                p1.next = p2.next;
                p2 = p1.next;
            }
        }
        return head;
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
        ListNode res = new Solution1().deleteDuplicates(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

