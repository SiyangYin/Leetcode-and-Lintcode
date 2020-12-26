import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param root1: the first tree
     * @param root2: the second tree
     * @return: returns whether the leaf sequence is the same
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // write your code here.
        List<Integer> leaves1 = new ArrayList<>(), leaves2 = new ArrayList<>();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        if (leaves1.size() != leaves2.size()) {
            return false;
        }
    
        for (int i = 0; i < leaves1.size(); i++) {
            if (!leaves1.get(i).equals(leaves2.get(i))) {
                return false;
            }
        }
        
        return true;
    }
    
    private void dfs(TreeNode root, List<Integer> leaves) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return;
        }
        
        dfs(root.left, leaves);
        dfs(root.right, leaves);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}