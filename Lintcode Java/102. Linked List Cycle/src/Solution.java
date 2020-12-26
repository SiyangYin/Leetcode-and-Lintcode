public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        // write your code here
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        
        if (fast == null || fast.next == null) {
            return false;
        } else {
            return true;
        }
        
    }
    
    public static void main(String[] args) {
        ListNode head = null;
        System.out.println(new Solution().hasCycle(head));
    }
}

