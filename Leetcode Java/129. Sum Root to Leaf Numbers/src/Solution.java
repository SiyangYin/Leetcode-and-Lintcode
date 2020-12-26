import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        List<Integer> nums = new ArrayList<>();
        dfs(root, root.val, nums);
        
        int sum = 0;
        
        for (Integer num : nums) {
             sum += num;
        }
        
        return sum;
    }
    
    private void dfs(TreeNode root, int cur, List<Integer> nums) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            nums.add(cur);
            return;
        }
        if (root.left != null) {
            dfs(root.left, cur * 10 + root.left.val, nums);
        }
        if (root.right != null) {
            dfs(root.right, cur * 10 + root.right.val, nums);
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(0);
        System.out.println(new Solution().sumNumbers(root));
    }
}

