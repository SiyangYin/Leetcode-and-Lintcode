public class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode cur = root, prev = null, p = null, q = null;
        while (cur != null) {
            TreeNode left = cur.left;
            if (left == null) {
                if (prev != null && prev.val > cur.val) {
                    if (p == null) {
                        p = prev;
                    }
                    
                    q = cur;
                }
                
                prev = cur;
                cur = cur.right;
            } else {
                while (left.right != null && left.right != cur) {
                    left = left.right;
                }
                
                if (left.right == null) {
                    left.right = cur;
                    cur = cur.left;
                } else {
                    left.right = null;
                    if (prev != null && prev.val > cur.val) {
                        if (p == null) {
                            p = prev;
                        }
                        
                        q = cur;
                    }
                    
                    prev = cur;
                    cur = cur.right;
                }
            }
        }
        
        swap(p, q);
    }
    
    void swap(TreeNode p, TreeNode q) {
        int tmp = p.val;
        p.val = q.val;
        q.val = tmp;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}
