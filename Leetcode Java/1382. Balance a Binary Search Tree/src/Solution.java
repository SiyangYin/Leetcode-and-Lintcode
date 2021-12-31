import java.util.ArrayList;
import java.util.List;

public class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            TreeNode mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            
            list.add(cur);
            cur = cur.right;
        }
        
        return dfs(list, 0, list.size() - 1);
    }
    
    TreeNode dfs(List<TreeNode> list, int l, int r) {
        if (l > r) {
            return null;
        }
        
        if (l == r) {
            TreeNode node = list.get(l);
            node.left = node.right = null;
            return node;
        }
        
        int mid = l + (r - l >> 1);
        TreeNode res = list.get(mid);
        res.left = dfs(list, l, mid - 1);
        res.right = dfs(list, mid + 1, r);
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