import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param head: the head of linked list.
     * @return: An integer list
     */
    public List<Integer> toArrayList(ListNode head) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(head.val);
            head = head.next;
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