import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    /**
     * @param head: the given linked list
     * @return: the array that store the values in reverse order
     */
    public List<Integer> reverseStore(ListNode head) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        
        Collections.reverse(list);
        return list;
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