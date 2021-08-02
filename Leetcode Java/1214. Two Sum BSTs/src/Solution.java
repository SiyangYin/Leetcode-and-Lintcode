import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Solution {
    
    class BSTIterator implements Iterator<TreeNode> {
        
        private Deque<TreeNode> stk;
        private boolean descending;
        
        public BSTIterator(TreeNode root, boolean descending) {
            this.descending = descending;
            stk = new LinkedList<>();
            if (!descending) {
                while (root != null) {
                    stk.push(root);
                    root = root.left;
                }
            } else {
                while (root != null) {
                    stk.push(root);
                    root = root.right;
                }
            }
        }
        
        public TreeNode peekNext() {
            return stk.peek();
        }
        
        @Override
        public boolean hasNext() {
            return !stk.isEmpty();
        }
        
        @Override
        public TreeNode next() {
            TreeNode top = stk.pop();
            if (!descending) {
                TreeNode right = top.right;
                while (right != null) {
                    stk.push(right);
                    right = right.left;
                }
            } else {
                TreeNode left = top.left;
                while (left != null) {
                    stk.push(left);
                    left = left.right;
                }
            }
            
            return top;
        }
    }
    
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        BSTIterator it1 = new BSTIterator(root1, false), it2 = new BSTIterator(root2, true);
        while (it1.hasNext() && it2.hasNext()) {
            int v1 = it1.peekNext().val, v2 = it2.peekNext().val;
            if (v1 + v2 < target) {
                it1.next();
            } else if (v1 + v2 > target) {
                it2.next();
            } else {
                return true;
            }
        }
        
        return false;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}