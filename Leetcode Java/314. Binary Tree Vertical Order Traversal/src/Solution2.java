import java.util.*;

public class Solution2 {
    class Pair {
        TreeNode node;
        int column;
        Pair(TreeNode node, int column) {
            this.node = node;
            this.column = column;
        }
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            map.putIfAbsent(cur.column, new ArrayList<>());
            map.get(cur.column).add(cur.node.val);
            if (cur.node.left != null) {
                queue.offer(new Pair(cur.node.left, cur.column - 1));
            }
            if (cur.node.right != null) {
                queue.offer(new Pair(cur.node.right, cur.column + 1));
            }
        }
    
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        
        return res;
    }
}
