public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        TreeNode root = null;
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            root = new TreeNode(head.val);
            return root;
        }
        if (head.next.next == null) {
            root = new TreeNode(head.next.val);
            root.left = new TreeNode(head.val);
            return root;
        }
        // if (head.next.next.next == null) {
        //     root = new TreeNode(head.next.val);
        //     root.left = new TreeNode(head.val);
        //     root.right = new TreeNode(head.next.next.val);
        //     return root;
        // }
        
        ListNode beforeMid = findBeforeMid(head);
        root = new TreeNode(beforeMid.next.val);
        root.right = sortedListToBST(beforeMid.next.next);
        beforeMid.next = null;
        root.left = sortedListToBST(head);
        
        return root;
    }
    
    private ListNode findBeforeMid(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        // head.next.next.next = new ListNode(5);
        // head.next.next.next.next = new ListNode(9);
        // head.next.next.next.next.next = new ListNode(10);
        // head.next.next.next.next.next.next = new ListNode(11);
        
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
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}