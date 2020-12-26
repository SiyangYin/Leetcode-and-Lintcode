import java.util.*;

public class Solution {
    private TreeNode start;
    
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        dfs(root, null, k, graph);
        
        Set<TreeNode> visited = new HashSet<>();
        visited.add(start);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(start);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                    return cur.val;
                }
    
                for (TreeNode next : graph.get(cur)) {
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
        }
        
        return -1;
    }
    
    private void dfs(TreeNode cur, TreeNode parent, int k, Map<TreeNode, List<TreeNode>> graph) {
        if (cur == null) {
            return;
        }
        
        if (cur.val == k) {
            start = cur;
        }
        
        List<TreeNode> nexts = new ArrayList<>();
        if (cur.left != null) {
            nexts.add(cur.left);
        }
        if (cur.right != null) {
            nexts.add(cur.right);
        }
        if (parent != null) {
            nexts.add(parent);
        }
        
        graph.put(cur, nexts);
        
        dfs(cur.left, cur, k, graph);
        dfs(cur.right, cur, k, graph);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}