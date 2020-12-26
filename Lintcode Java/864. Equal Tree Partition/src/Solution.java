import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param root: a TreeNode
     * @return: return a boolean
     */
    public boolean checkEqualTree(TreeNode root) {
        // write your code here
        Set<Integer> set = new HashSet<>();
        int sum = dfs(root, root, set);
        if (sum % 2 != 0) {
            return false;
        }
        
        return set.contains(sum / 2);
    }
    
    private int dfs(TreeNode cur, TreeNode root, Set<Integer> set) {
        if (cur == null) {
            return 0;
        }
        
        int sum = cur.val + dfs(cur.left, root, set) + dfs(cur.right, root, set);
        if (cur != root) {
            set.add(sum);
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(10);
        root.right = new TreeNode(-10);
        root.right.left = new TreeNode(-2);
        root.right.right = new TreeNode(-3);
        
        System.out.println(new Solution().checkEqualTree(root));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}