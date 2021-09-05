import java.util.Arrays;

public class Solution {
    /*
     * @param : the root of tree
     * @param : the target sum
     * @return: two numbers from tree which sum is n
     */
    public int[] twoSum(TreeNode root, int n) {
        // write your code here
        TreeNode cur = root;
        while (cur != null) {
            TreeNode prev = cur.left;
            if (prev == null) {
                if (find(root, n - cur.val)) {
                    return new int[]{cur.val, n - cur.val};
                }
                
                cur = cur.right;
            } else {
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                
                if (prev.right == cur) {
                    if (find(root, n - cur.val)) {
                        return new int[]{cur.val, n - cur.val};
                    }
                    
                    prev.right = null;
                    cur = cur.right;
                } else {
                    prev.right = cur;
                    cur = cur.left;
                }
            }
        }
        
        return null;
    }
    
    boolean find(TreeNode root, int x) {
        while (root != null) {
            if (x < root.val) {
                root = root.left;
            } else if (x > root.val) {
                root = root.right;
            } else {
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);
        System.out.println(Arrays.toString(new Solution().twoSum(root, 3)));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}