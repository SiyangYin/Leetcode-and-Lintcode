import java.util.*;

public class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if (K == 0) {
            return Arrays.asList(target.val);
        }
        
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        dfs(root, graph);
        
        int step = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        Set<TreeNode> set = new HashSet<>();
        set.add(target);
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                for (TreeNode next : graph.get(cur)) {
                    if (!set.contains(next)) {
                        queue.offer(next);
                        set.add(next);
                    }
                }
            }
            
            if (step == K) {
                List<Integer> res = new ArrayList<>();
                while (!queue.isEmpty()) {
                    res.add(queue.poll().val);
                }
                
                return res;
            }
        }
        
        return new ArrayList<>();
    }
    
    private void dfs(TreeNode cur, Map<TreeNode, List<TreeNode>> graph) {
        if (cur == null) {
            return;
        }
    
        graph.putIfAbsent(cur, new ArrayList<>());
        if (cur.left != null) {
            graph.get(cur).add(cur.left);
            graph.putIfAbsent(cur.left, new ArrayList<>());
            graph.get(cur.left).add(cur);
        }
        if (cur.right != null) {
            graph.get(cur).add(cur.right);
            graph.putIfAbsent(cur.right, new ArrayList<>());
            graph.get(cur.right).add(cur);
        }
        
        dfs(cur.left, graph);
        dfs(cur.right, graph);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}