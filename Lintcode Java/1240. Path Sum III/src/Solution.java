import java.util.HashMap;
import java.util.Map;

public class Solution {
    
    private int res;
    
    /**
     * @param root:
     * @param sum:
     * @return: the num of sum path
     */
    public int pathSum(TreeNode root, int sum) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        dfs(root, 0, sum, map);
        
        return res;
    }
    
    private void dfs(TreeNode root, int curSum, int sum, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        
        curSum += root.val;
        
        res += map.getOrDefault(curSum - sum, 0);
        
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        
        dfs(root.left, curSum, sum, map);
        dfs(root.right, curSum, sum, map);
        
        map.put(curSum, map.getOrDefault(curSum, 0) - 1);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        System.out.println(new Solution().pathSum(root, 8));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}