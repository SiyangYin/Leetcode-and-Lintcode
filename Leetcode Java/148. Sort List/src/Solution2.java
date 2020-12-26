public class Solution2 {
    public ListNode sortList(ListNode head) {
        int n = 0;
        for (ListNode p = head; p != null; p = p.next) {
            n++;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
    
        for (int i = 1; i < n; i *= 2) {
            ListNode cur = dummy;
            for (int j = 0; j + i < n; j += i * 2) {
                ListNode left = cur.next, right = cur.next;
                for (int k = 0; k < i; k++) {
                    right = right.next;
                }
                int l = 0, r = 0;
                while (l < i && r < i && right != null) {
                    if (left.val <= right.val) {
                        cur.next = left;
                        left = left.next;
                        l++;
                    } else {
                        cur.next = right;
                        right = right.next;
                        r++;
                    }
                    cur = cur.next;
                }
                while (l < i) {
                    cur.next = left;
                    cur = cur.next;
                    left = left.next;
                    l++;
                }
                while (r < i && right != null) {
                    cur.next = right;
                    cur = cur.next;
                    right = right.next;
                    r++;
                }
                cur.next = right;
            }
        }
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(5);
        
        ListNode res = new Solution2().sortList(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
