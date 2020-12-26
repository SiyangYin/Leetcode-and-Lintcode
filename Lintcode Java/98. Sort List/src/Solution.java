public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list, using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode secondHalf = mid.next;
        mid.next = null;
        
        ListNode l1 = sortList(head), l2 = sortList(secondHalf);
        return merge(l1, l2);
    }
    
    private ListNode findMid(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), prev = dummy;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                prev.next = l2;
                break;
            } else if (l2 == null) {
                prev.next = l1;
                break;
            } else {
                if (l1.val <= l2.val) {
                    prev.next = l1;
                    l1 = l1.next;
                } else {
                    prev.next = l2;
                    l2 = l2.next;
                }
                prev = prev.next;
            }
        }
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(-1);
        new Solution().sortList(head);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}