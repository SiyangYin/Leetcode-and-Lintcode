public class Solution {
    /**
     * @param head: the given linked list
     * @return:  the weighted sum in reverse order
     */
    public int weightedSumReverse(ListNode head) {
        // ListNode -> val: the value of node ,ListNode -> next: the next node of this node
        int res = 0, sum = 0;
        while (head != null) {
            sum += head.val;
            res += sum;
            head = head.next;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(1);
    
        System.out.println(new Solution().weightedSumReverse(head));
    }
}

class ListNode {
    int val;
    ListNode next;
    
    public ListNode(int x) {
        val = x;
    }
}