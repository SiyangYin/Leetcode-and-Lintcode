public class Solution2 {
    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        ListNode res = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = res;
            res = head;
            head = tmp;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode head2 = new Solution().reverse(head);
        while (head2 != null) {
            System.out.println(head2.val);
            head2 = head2.next;
        }
        
    }
}
