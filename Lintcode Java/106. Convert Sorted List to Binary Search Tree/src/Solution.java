public class Solution {
    /*
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy, prev = dummy;
        while (fast != null && fast.next != null) {
            if (slow != dummy) {
                prev = prev.next;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        
        prev.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(dummy.next);
        root.right = sortedListToBST(slow.next);
        
        return root;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(3);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(7);
        TreeNode root = new Solution().sortedListToBST(head);
        System.out.println(root.val);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}