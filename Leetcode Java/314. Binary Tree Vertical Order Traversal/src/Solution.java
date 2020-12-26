import java.util.*;

public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        Map<Integer, List<TreeNode>> tmp = new TreeMap<>();
        Map<TreeNode, Integer> depth = new HashMap<>();
        dfs(root, 0, 0, 0, tmp, depth);
    
        for (Map.Entry<Integer, List<TreeNode>> entry : tmp.entrySet()) {
            List<TreeNode> column = entry.getValue();
            column.sort(Comparator.comparingInt(depth::get));
            res.add(new ArrayList<>());
            for (TreeNode node : column) {
                res.get(res.size() - 1).add(node.val);
            }
        }
        
        return res;
    }
    
    private void dfs(TreeNode root, int left, int right, int depth, Map<Integer, List<TreeNode>> tmp, Map<TreeNode, Integer> map) {
        if (root == null) {
            return;
        }
        
        tmp.putIfAbsent(right - left, new ArrayList<>());
        tmp.get(right - left).add(root);
        map.put(root, depth);
        dfs(root.left, left + 1, right, depth + 1, tmp, map);
        dfs(root.right, left, right + 1,depth + 1, tmp, map);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.right = new TreeNode(11);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution().verticalOrder(root));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}