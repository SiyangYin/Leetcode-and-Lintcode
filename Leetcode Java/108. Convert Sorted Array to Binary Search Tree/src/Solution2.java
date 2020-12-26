public class Solution2 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        
        return buildBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode buildBST(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        // if (l == r) {
        //     return new TreeNode(nums[l]);
        // }
        
        int mid = l + ((r - l) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = buildBST(nums, l, mid - 1);
        root.right = buildBST(nums, mid + 1, r);
        
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode res = new Solution2().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(res.right.val);
    }
}
