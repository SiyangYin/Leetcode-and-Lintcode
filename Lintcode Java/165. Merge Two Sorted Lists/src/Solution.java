public class Solution {
    /**
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummy = new ListNode(0), cur = dummy;
        
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                cur.next = l2;
                break;
            } else if (l2 == null) {
                cur.next = l1;
                break;
            } else {
                if (l1.val <= l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
        }
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(8);
        ListNode l2 = new ListNode(2);
        ListNode head = new Solution().mergeTwoLists(l1, l2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
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