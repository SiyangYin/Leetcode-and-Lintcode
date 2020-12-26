import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        
        List<TreeNode> res = new ArrayList<>();
        dfs(root, set, res, true);
        
        return res;
    }
    
    private TreeNode dfs(TreeNode cur, Set<Integer> set, List<TreeNode> res, boolean isRoot) {
        if (cur == null) {
            return null;
        }
        
        boolean nextRoot = false, curDel = false;
        if (set.contains(cur.val)) {
            nextRoot = true;
            curDel = true;
        }
        
        cur.left = dfs(cur.left, set, res, nextRoot);
        cur.right = dfs(cur.right, set, res, nextRoot);
        
        if (curDel) {
            return null;
        } else {
            if (isRoot) {
                res.add(cur);
            }
            
            return cur;
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        
        int[] del = {3, 5};
        List<TreeNode> list = new Solution().delNodes(root, del);
        System.out.println(list);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}