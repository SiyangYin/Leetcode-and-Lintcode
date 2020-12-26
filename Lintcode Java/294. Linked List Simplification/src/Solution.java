public class Solution {
    /**
     * @param head: the linked list to be simplify.
     * @return: return the linked list after simplifiction.
     */
    public ListNode simplify(ListNode head) {
        // write your code here
        int count = 0;
        ListNode last = null, cur = head;
        while (cur != null) {
            count++;
            if (cur.next == null) {
                last = cur;
            }
            
            cur = cur.next;
        }
    
        String num = String.valueOf(count - 2);
        cur = head;
        for (int i = 0; i < num.length(); i++) {
            cur.next = new ListNode((int) num.charAt(i));
            cur = cur.next;
        }
        
        cur.next = last;
        return head;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(104);
        head.next = new ListNode(101);
        head.next.next = new ListNode(108);
        head.next.next.next = new ListNode(108);
        head.next.next.next.next = new ListNode(111);
        ListNode res = new Solution().simplify(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    
    public ListNode(int val) {
        this.val = val;
    }
}