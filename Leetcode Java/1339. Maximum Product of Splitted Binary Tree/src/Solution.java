import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private long min = Long.MAX_VALUE;
    private long subSum = 0;
    public int maxProduct(TreeNode root) {
        long sum = getSum(root);
        dfs(root, sum);
        return (int)(subSum * (sum - subSum) % (Math.pow(10, 9) + 7));
    }

    public void dfs(TreeNode node, long sum) {
        if (node != null) {
            long diff = Math.abs(node.val - sum / 2);
            if (diff < min) {
                min = diff;
                subSum = node.val;
                dfs(node.left, sum);
                dfs(node.right, sum);
            }
        }
    }

    public int getSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        else  {
            node.val += getSum(node.left) + getSum(node.right);
            return node.val;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}