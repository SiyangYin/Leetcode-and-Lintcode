import java.util.Random;

public class Solution {
    
    private ListNode head;
    private Random random;
    
    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public Solution(ListNode head) {
        this.head = head;
        random = new Random();
    }
    
    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        int res = -1, n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            n++;
            if (random.nextInt() % n == 0) {
                res = cur.val;
            }
        }
        
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;
    
    public ListNode(int val) {
        this.val = val;
    }
}