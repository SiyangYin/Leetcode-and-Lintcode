import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int x : G) {
            set.add(x);
        }
        
        int count = 0;
        while (head != null) {
            if (set.contains(head.val)) {
                count++;
                while (head != null && set.contains(head.val)) {
                    head = head.next;
                }
            }
            
            while (head != null && !set.contains(head.val)) {
                head = head.next;
            }
        }
        
        return count;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
