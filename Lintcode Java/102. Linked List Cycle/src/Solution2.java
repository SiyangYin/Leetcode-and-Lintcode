public class Solution2 {
    public Boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        
        ListNode fast, slow;
        fast = head.next;
        slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
    
    public static void main(String[] args) {
        ListNode head = null;
        System.out.println(new Solution2().hasCycle(head));
    }
}