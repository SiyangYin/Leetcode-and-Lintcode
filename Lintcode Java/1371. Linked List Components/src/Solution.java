import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param head: the head
     * @param G: an array
     * @return: the number of connected components in G
     */
    public int numComponents(ListNode head, int[] G) {
        // Write your code here
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : G) {
            set.add(i);
        }
        
        ListNode dummy = new ListNode(0), prev = dummy;
        dummy.next = head;
        
        while (prev.next != null) {
            if (set.contains(prev.next.val)) {
                res++;
                while (prev.next != null && set.contains(prev.next.val)) {
                    prev = prev.next;
                }
            } else {
                prev = prev.next;
            }
        }
        
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}