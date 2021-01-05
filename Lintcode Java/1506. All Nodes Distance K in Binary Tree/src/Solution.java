import java.util.*;

public class Solution {
    /**
     * @param root:   the root of the tree
     * @param target: the target
     * @param K:      the given K
     * @return: All Nodes Distance K in Binary Tree
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        // Write your code here
        if (K == 0) {
            return Arrays.asList(target.val);
        }
        
        List<Integer> res = new ArrayList<>();
        Map<TreeNode, Set<TreeNode>> graph = buildGraph(root);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                for (TreeNode next : graph.get(cur)) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                        
                        if (step == K) {
                            res.add(next.val);
                        }
                    }
                }
            }
            
            if (step == K) {
                return res;
            }
        }
        
        return res;
    }
    
    private Map<TreeNode, Set<TreeNode>> buildGraph(TreeNode root) {
        Map<TreeNode, Set<TreeNode>> graph = new HashMap<>();
        dfs(root, graph);
        return graph;
    }
    
    private void dfs(TreeNode cur, Map<TreeNode, Set<TreeNode>> graph) {
        if (cur == null) {
            return;
        }
        
        graph.putIfAbsent(cur, new HashSet<>());
        if (cur.left != null) {
            graph.get(cur).add(cur.left);
            graph.putIfAbsent(cur.left, new HashSet<>());
            graph.get(cur.left).add(cur);
            dfs(cur.left, graph);
        }
        if (cur.right != null) {
            graph.get(cur).add(cur.right);
            graph.putIfAbsent(cur.right, new HashSet<>());
            graph.get(cur.right).add(cur);
            dfs(cur.right, graph);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}