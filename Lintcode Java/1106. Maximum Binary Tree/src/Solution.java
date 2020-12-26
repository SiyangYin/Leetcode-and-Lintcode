public class Solution {
    /**
     * @param nums: an array
     * @return: the maximum tree
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return null;
        }
        
        return dfs(nums, 0, nums.length - 1);
    }
    
    private TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        
        int max = Integer.MIN_VALUE, maxIdx = 0;
        for (int i = left; i <= right; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIdx = i;
            }
        }
        
        TreeNode root = new TreeNode(max);
        root.left = dfs(nums, left, maxIdx - 1);
        root.right = dfs(nums, maxIdx + 1, right);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}