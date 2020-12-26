public class Solution2 {
    /**
     * @param head: head is the head of the linked list
     * @return: head of linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        ListNode dummy = new ListNode(0), prev = dummy;
        dummy.next = head;
        ListNode cur = head;
        while (cur != null) {
            if (cur.next == null || cur.next.val != cur.val) {
                prev.next = cur;
                prev = prev.next;
                cur = cur.next;
            } else {
                while (cur.next != null && cur.next.val == cur.val) {
                    cur = cur.next;
                }
            }
        }
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        ListNode res = new Solution2().deleteDuplicates(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}