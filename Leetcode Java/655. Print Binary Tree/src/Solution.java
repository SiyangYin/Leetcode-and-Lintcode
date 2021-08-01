import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        int h = getHeight(root);
        for (int i = 0; i < h; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < (1 << h) - 1; j++) {
                list.add("");
            }
            res.add(list);
        }
        
        dfs(root, 0, 0, (1 << h) - 1, res);
        return res;
    }
    
    private void dfs(TreeNode cur, int depth, int l, int r, List<List<String>> res) {
        if (cur == null) {
            return;
        }
        
        int mid = l + (r - l >> 1);
        res.get(depth).set(mid, String.valueOf(cur.val));
        dfs(cur.left, depth + 1, l, mid, res);
        dfs(cur.right, depth + 1, mid + 1, r, res);
    }
    
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}