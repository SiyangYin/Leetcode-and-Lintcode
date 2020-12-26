public class Solution {
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        double diff = Math.abs(root.val - target);
        
        while (root != null) {
            if (Math.abs(root.val - target) < diff) {
                res = root.val;
                diff = Math.abs(root.val - target);
            }
            
            if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
    
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}
