public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = arrToBst(nums, 0, nums.length - 1);
        return root;
    }
    
    private static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }
    
    private TreeNode arrToBst(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        
        if (end - start == 1) {
            TreeNode root = new TreeNode(nums[start]);
            root.right = new TreeNode(nums[end]);
            return root;
        }
        
        if (end - start == 2) {
            TreeNode root = new TreeNode(nums[start + 1]);
            root.left = new TreeNode(nums[start]);
            root.right = new TreeNode(nums[end]);
            return root;
        }
    
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = arrToBst(nums, start, mid - 1);
        root.right = arrToBst(nums, mid + 1, end);
        return root;
    }
    
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7};
        TreeNode root = new Solution().sortedArrayToBST(nums);
        inorder(root);
        
    }
}


class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}