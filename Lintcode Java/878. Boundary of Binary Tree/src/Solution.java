import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    /**
     * @param root: a TreeNode
     * @return: a list of integer
     */
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        res.add(root.val);
        dfs(root.left, true, false, res);
        dfs(root.right, false, true, res);
        return res;
    }
    
    private void dfs(TreeNode cur, boolean leftBound, boolean rightBound, List<Integer> res) {
        if (cur == null) {
            return;
        }
        
        if (cur.left == null && cur.right == null) {
            res.add(cur.val);
            return;
        }
        
        if (leftBound) {
            res.add(cur.val);
        }
        
        dfs(cur.left, leftBound, rightBound && cur.right == null, res);
        dfs(cur.right, leftBound && cur.left == null, rightBound, res);
        
        if (rightBound) {
            res.add(cur.val);
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(9);
        root.right.left.right = new TreeNode(10);
        System.out.println(new Solution().boundaryOfBinaryTree(root));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}