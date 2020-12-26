import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if (N % 2 == 0) {
            return res;
        }
        
        return dfs(N);
    }
    
    private List<TreeNode> dfs(int N) {
        List<TreeNode> res = new ArrayList<>();
        if (N == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        
        for (int i = 1; i < N - 1; i += 2) {
            List<TreeNode> left = dfs(i), right = dfs(N - 1 - i);
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
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}