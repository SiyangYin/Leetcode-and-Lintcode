import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param head: the given doubly linked list
     * @param nodes: the given nodes array
     * @return: the number of blocks in the given array
     */
    public int blockNumber(DoublyListNode head, int[] nodes) {
        // write your code here
        DoublyListNode dummy = new DoublyListNode(0);
        dummy.next = head;
        DoublyListNode prev = dummy;
    
        Set<Integer> set = new HashSet<>();
        for (int node : nodes) {
            set.add(node);
        }
        
        int res = 0;
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

class DoublyListNode {
    int val;
    DoublyListNode prev, next;
    DoublyListNode(int x) {
        val = x;
    }
}