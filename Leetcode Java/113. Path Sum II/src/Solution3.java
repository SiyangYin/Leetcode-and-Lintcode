import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, new ArrayList<>(), res, 0, targetSum);
        return res;
    }

    public void dfs(TreeNode node, List<Integer> list, List<List<Integer>> res, int sum, int targetSum) {
        sum += node.val;
        list.add(node.val);
        if (sum == targetSum && isLeaf(node)) {
            res.add(new ArrayList<>(list));
        }
        if (node.left != null) {
            dfs(node.left, list, res, sum, targetSum);
        }
        if (node.right != null) {
            dfs(node.right, list, res, sum , targetSum);
        }
        list.remove(list.size() - 1);
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(new Solution3().pathSum(root, 22));
    }
}
