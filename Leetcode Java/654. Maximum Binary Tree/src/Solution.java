public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }
    
    private TreeNode build(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        
        int max = Integer.MIN_VALUE, maxIdx = 0;
        for (int i = l; i <= r; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }
        
        TreeNode root = new TreeNode(max);
        root.left = build(nums, l, maxIdx - 1);
        root.right = build(nums, maxIdx + 1, r);
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