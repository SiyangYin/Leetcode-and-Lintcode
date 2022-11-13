import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null) {
            return null;
        }
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            root = node;
        }
        else if (depth == 2) {
            TreeNode node1 = new TreeNode(val);
            node1.left = root.left;
            root.left = node1;
            TreeNode node2 = new TreeNode(val);
            node2.right = root.right;
            root.right = node2;
        }
        else {
            root.left = addOneRow(root.left, val, depth - 1);
            root.right = addOneRow(root.right, val, depth - 1);
        }
        return root;
    }
}

