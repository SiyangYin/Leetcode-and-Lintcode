public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        
        if (head.val == val) {
            head.next = removeElements(head.next, val);
            return head.next;
        }
        
        head.next = removeElements(head.next, val);
        return head;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(6);
    
        ListNode res = new Solution2().removeElements(head, 6);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    
    }
}
