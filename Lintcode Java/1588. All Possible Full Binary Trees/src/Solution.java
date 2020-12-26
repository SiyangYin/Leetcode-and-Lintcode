import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param n: An integer
     * @return: A list of root
     */
    public List<TreeNode> allPossibleFBT(int n) {
        // write your code here
        if (n % 2 == 0) {
            return new ArrayList<>();
        }
        
        return dfs(n);
    }
    
    private List<TreeNode> dfs(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        
        List<TreeNode> res = new ArrayList<>();
        if (n == 1) {
            res.add(new TreeNode(0));
            return res;
        }
    
        for (int i = 1; i <= n - 2; i += 2) {
            List<TreeNode> left = dfs(i), right = dfs(n - 1 - i);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        List<TreeNode> res = new Solution().allPossibleFBT(19);
        System.out.println(res);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}