public class Solution3 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        
        ListNode mid = findMid(head);
        ListNode l2 = reverse(mid.next);
        mid.next = null;
        merge(head, l2);
    }
    
    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode cur = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = cur;
            cur = head;
            head = tmp;
        }
        return cur;
    }
    
    private void merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while (l1 != null && l2 != null) {
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
            cur.next = l2;
            cur = cur.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            cur.next = l1;
            cur = cur.next;
        }
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        
        new Solution3().reorderList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
