public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        while ((prev = reverseK(prev, k)) != null) {}
        
        return dummy.next;
    }
    
    private ListNode reverseK(ListNode cur, int k) {
        //  return the the last node of the reversed k nodes
        //  cur -> (n1 -> n2 -> ... -> nk-1 -> nk = tail) -> nk+1
        ListNode n1 = cur.next;
        ListNode tail = cur;
        int count = k;
        while (count-- > 0) {
            tail = tail.next;
            if (tail == null) {
                return null;
            }
        }
        
        ListNode nkplus1 = tail.next;
        
        //  set tail = n1, prev will store the head of the reversed k nodes
        tail = n1;
        
        ListNode prev = null;
        while (n1 != nkplus1) {
            ListNode tmp = n1.next;
            n1.next = prev;
            prev = n1;
            n1 = tmp;
        }
        
        cur.next = prev;
        tail.next = nkplus1;
        
        return tail;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        ListNode newHead = new Solution().reverseKGroup(head, 3);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
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