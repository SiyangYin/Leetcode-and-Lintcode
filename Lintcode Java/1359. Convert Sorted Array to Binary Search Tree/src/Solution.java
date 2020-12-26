public class Solution {
    /**
     * @param nums: the sorted array
     * @return: the root of the tree
     */
    public TreeNode convertSortedArraytoBinarySearchTree(int[] nums) {
        // Write your code here.
        return buildRoot(nums, 0, nums.length - 1);
    }
    
    private TreeNode buildRoot(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        System.out.println("haha");
        int m = l + (r - l >> 1);
        TreeNode root = new TreeNode(nums[m]);
        root.left = buildRoot(nums, l, m - 1);
        root.right = buildRoot(nums, m + 1, r);
        return root;
    }
    
    public static void main(String[] args) {
        new Solution().convertSortedArraytoBinarySearchTree(new int[]{-10, -3, 0, 5, 9});
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}