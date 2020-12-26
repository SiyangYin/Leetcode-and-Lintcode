import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    class Triplet {
        int val, x, y;
    
        public Triplet(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Triplet> list = new ArrayList<>();
        dfs(root, 0, 0, list);
        list.sort((t1, t2) -> t1.y != t2.y ? Integer.compare(t1.y, t2.y) : t1.x != t2.x ? Integer.compare(t1.x, t2.x) : Integer.compare(t1.val, t2.val));
    
        int curY = Integer.MIN_VALUE;
        for (Triplet triplet : list) {
            if (triplet.y > curY) {
                res.add(new ArrayList<>());
                res.get(res.size() - 1).add(triplet.val);
                curY = triplet.y;
            } else {
                res.get(res.size() - 1).add(triplet.val);
            }
        }
        
        return res;
    }
    
    private void dfs(TreeNode cur, int x, int y, List<Triplet> list) {
        if (cur == null) {
            return;
        }
        list.add(new Triplet(cur.val, x, y));
        dfs(cur.left, x + 1, y - 1, list);
        dfs(cur.right, x + 1, y + 1, list);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution().verticalTraversal(root));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}