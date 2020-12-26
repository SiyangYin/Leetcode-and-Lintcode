public class Solution {
    /*
     * @param node: a list node in the list
     * @param x: An integer
     * @return: the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        // write your code here
        ListNode xNode  = new ListNode(x);
        if (node == null) {
            return xNode;
        }
        
        ListNode prev = node;
        do {
            if (prev.val <= x && x <= prev.next.val) {
                break;
            }
            prev = prev.next;
        } while (prev != node);
        
        if (prev.val <= x && x <= prev.next.val) {
            return insertNode(prev, xNode);
        }
    
        do {
            if (prev.val > prev.next.val) {
                break;
            }
            prev = prev.next;
        } while (prev != node);
        
        return insertNode(prev, xNode);
    }
    
    private ListNode insertNode(ListNode prev, ListNode insert) {
        insert.next = prev.next;
        prev.next = insert;
        return insert;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = head;
        head = null;
        ListNode res = new Solution().insert(head, 4);
        ListNode cur = res;
        do {
            System.out.println(cur.val);
            cur = cur.next;
        }
        while (cur != res);
    }
}

class ListNode {
    int val;
    ListNode next;
    
    ListNode(int x) {
        val = x;
    }
}
