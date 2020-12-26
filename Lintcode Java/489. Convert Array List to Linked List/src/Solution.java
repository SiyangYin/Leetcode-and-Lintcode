import java.util.List;

public class Solution {
    /*
     * @param nums: an integer array
     * @return: the first node of linked list
     */
    public ListNode toLinkedList(List<Integer> nums) {
        // write your code here
        if (nums == null || nums.size() == 0) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
    
        for (int num : nums) {
            prev.next = new ListNode(num);
            prev = prev.next;
        }
        
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    
    ListNode(int x) {
        val = x;
    }
}