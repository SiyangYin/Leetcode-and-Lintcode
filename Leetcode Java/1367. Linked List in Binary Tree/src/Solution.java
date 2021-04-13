public class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (dfs(head, root)) {
            return true;
        }
        
        if (root == null) {
            return false;
        }
        
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }
    
    private boolean dfs(ListNode head, TreeNode cur) {
        if (head == null) {
            return true;
        }
        if (cur == null) {
            return false;
        }
        
        if (head.val != cur.val) {
            return false;
        }
        
        return dfs(head.next, cur.left) || dfs(head.next, cur.right);
    }
}

class ListNode {
    int val;
    ListNode next;
    
    public ListNode(int val) {
        this.val = val;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}