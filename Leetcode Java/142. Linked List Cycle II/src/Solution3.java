public class Solution3 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (fast != null && fast.next != null && slow != fast);
        if (slow != fast) {
            return null;
        }
        ListNode cur = head;
        while (cur != slow) {
            cur = cur.next;
            slow = slow.next;
        }
        return cur;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head.next;
        System.out.println(new Solution3().detectCycle(head).val);
    }
}

