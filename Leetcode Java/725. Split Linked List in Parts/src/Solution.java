public class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = root;
        ListNode prev = dummy;
        
        int length = len(root);
        ListNode[] res = new ListNode[k];
        
        int partLength = length / k, numOfLonger = 0;
        if (partLength * k != length) {
            numOfLonger = length % k;
        }
        
        int ind = 0;
        ListNode tmp = null;
        for (int i = 0; i < numOfLonger; i++) {
            res[ind++] = prev.next;
            tmp = prev;
            for (int j = 0; j < partLength + 1; j++) {
                prev = prev.next;
            }
            tmp.next = null;
        }
    
        for (int i = 0; i < k - numOfLonger; i++) {
            res[ind++] = prev.next;
            tmp = prev;
            for (int j = 0; j < partLength; j++) {
                prev = prev.next;
            }
            tmp.next = null;
        }
        
        return res;
    }
    
    private int len(ListNode head) {
        int l = 0;
        while (head != null) {
            head = head.next;
            l++;
        }
        
        return l;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
    
        ListNode[] listNodes = new Solution().splitListToParts(head, 2);
        for (int i = 0; i < listNodes.length; i++) {
            System.out.println(listNodes[i].val);
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}