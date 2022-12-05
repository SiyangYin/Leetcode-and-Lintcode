import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    private int max = 0;
    private Map<TreeNode, Integer> zigMap = new HashMap<>();
    private Map<TreeNode, Integer> zagMap = new HashMap<>();
    public int longestZigZag(TreeNode root) {
        dfs(root);
        return max;
    }

    public void dfs(TreeNode node) {
        if (node != null) {
            max = Math.max(max, Math.max(findZag(node.right) + 1, findZig(node.left) + 1));
            dfs(node.left);
            dfs(node.right);
        }
    }

    public int findZig(TreeNode node) {
        if (zigMap.containsKey(node)) {
            return zigMap.get(node);
        }
        if (node == null) {
            zigMap.put(node, -1);
            return -1;
        }
        zigMap.put(node, findZag(node.right) + 1);
        return zigMap.get(node);
    }

    public int findZag(TreeNode node) {
        if (zagMap.containsKey(node)) {
            return zagMap.get(node);
        }
        if (node == null) {
            zagMap.put(node, -1);
            return -1;
        }
        zagMap.put(node, findZig(node.left) + 1);
        return zagMap.get(node);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.left = new TreeNode(4);
        root.right.right.left.right = new TreeNode(5);
        System.out.println(new Solution1().longestZigZag(root));
    }
}

