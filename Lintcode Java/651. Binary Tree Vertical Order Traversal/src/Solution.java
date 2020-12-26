import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    
    private int zeroIdx;
    class Pair {
        int val, depth;
    
        public Pair(int val, int depth) {
            this.val = val;
            this.depth = depth;
        }
    }
    
    /**
     * @param root: the root of tree
     * @return: the vertical order traversal
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        List<List<Pair>> lists = new LinkedList<>();
        dfs(root, 0, 0, lists);
    
        for (List<Pair> list : lists) {
            list.sort((p1, p2) -> Integer.compare(p1.depth, p2.depth));
            List<Integer> col = new ArrayList<>();
            for (Pair pair : list) {
                col.add(pair.val);
            }
            
            res.add(col);
        }
        
        return res;
    }
    
    private void dfs(TreeNode cur, int x, int y, List<List<Pair>> lists) {
        if (cur == null) {
            return;
        }
        
        if (zeroIdx + y < 0) {
            lists.add(0, new ArrayList<>());
            zeroIdx++;
        } else if (zeroIdx + y >= lists.size()) {
            lists.add(new ArrayList<>());
        }
        
        lists.get(zeroIdx + y).add(new Pair(cur.val, x));
        
        dfs(cur.left, x + 1, y - 1, lists);
        dfs(cur.right, x + 1, y + 1, lists);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}