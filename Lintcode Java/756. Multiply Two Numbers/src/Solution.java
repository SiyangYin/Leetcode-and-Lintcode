public class Solution {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the product list of l1 and l2
     */
    public long multiplyLists(ListNode l1, ListNode l2) {
        // write your code here
        return compute(l1) * compute(l2);
    }
    
    private long compute(ListNode l) {
        long n = 0;
        while (l != null) {
            n *= 10;
            n += l.val;
            l = l.next;
        }
        
        return n;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}