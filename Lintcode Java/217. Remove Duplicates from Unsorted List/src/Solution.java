import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: Head node.
     */
    public ListNode removeDuplicates(ListNode head) {
        // write your code here
        Set<Integer> set = new HashSet<>();
        ListNode dummy = new ListNode(0), prev = dummy;
        while (head != null) {
            if (!set.contains(head.val)) {
                prev.next = head;
                prev = prev.next;
                set.add(head.val);
            }
            head = head.next;
        }
        prev.next = null;
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    
    public ListNode(int val) {
        this.val = val;
    }
}