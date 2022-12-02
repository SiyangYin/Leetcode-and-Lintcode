import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> res = new ArrayList<>();
        if (root.val != voyage[0]) {
            return Arrays.asList(-1);
        }
        dfs(root, voyage, res, 1);
        return res;
    }

    public int dfs(TreeNode root, int[] voyage, List<Integer> res, int i) {
        if (i >= voyage.length || root == null) {
            return i - 1;
        }
        if (root.left != null && voyage[i] != root.left.val) {
            res.add(root.val);
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
            if (root.left != null && voyage[i] != root.left.val) {
                res.clear();
                res.add(-1);
                return voyage.length - 1;
            }
        }
        i = dfs(root.left, voyage, res, i + 1);
        if (root.right != null && voyage[i] != root.right.val) {
            res.clear();
            res.add(-1);
            return voyage.length - 1;
        }
        return dfs(root.right, voyage, res, i + 1);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}