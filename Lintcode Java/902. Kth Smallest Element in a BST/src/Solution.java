import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param root: the given BST
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    public int kthSmallest(TreeNode root, int k) {
        // write your code here
        Map<TreeNode, Integer> map = new HashMap<>();
        int x = 0;
        while ((x = count(root.left, map)) != k - 1) {
            if (x > k - 1) {
                root = root.left;
            } else {
                root = root.right;
                k -= x + 1;
            }
        }
        
        return root.val;
    }
    
    private int count(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        
        if (map.containsKey(root)) {
            return map.get(root);
        }
        
        int left = count(root.left, map);
        int right = count(root.right, map);
        map.put(root, left + right + 1);
        
        return left + right + 1;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
    
        System.out.println(new Solution().kthSmallest(root, 1));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}