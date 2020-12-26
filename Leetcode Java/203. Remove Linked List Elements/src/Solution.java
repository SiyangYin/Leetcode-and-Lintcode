import java.util.ArrayList;

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ArrayList<ListNode> list = new ArrayList<>() {{
           add(new ListNode(1));
           add(new ListNode(2));
           add(new ListNode(6));
           add(new ListNode(3));
           add(new ListNode(4));
           add(new ListNode(5));
           add(new ListNode(6));
        }};
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for (ListNode node : list) {
            dummy.next = node;
            dummy = dummy.next;
        }
        head = head.next;
        ListNode h = new Solution().removeElements(head, 6);
        while (h != null) {
            System.out.println(h.val);
            h = h.next;
        }
        
    }
    
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
