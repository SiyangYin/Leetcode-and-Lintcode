import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        range(root, k1, k2, res);
        return res;
    }
    
    private void range(TreeNode root, int k1, int k2, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.val > k1) {
            range(root.left, k1, k2, res);
        }
        if (root.val >= k1 && root.val <= k2) {
            res.add(root.val);
        }
        if (root.val < k2) {
            range(root.right, k1, k2, res);
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.right = new TreeNode(22);
    
        System.out.println(new Solution().searchRange(root, 10, 22));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}