import java.util.*;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (root == null) {
            return res;
        }
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> row = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                TreeNode x = queue.poll();
                if (!reverse) {
                    row.add(x.val);
                } else {
                    row.add(0, x.val);
                }
                if (x.left != null) {
                    queue.offer(x.left);
                }
                if (x.right != null) {
                    queue.offer(x.right);
                }
            }
            reverse = !reverse;
            res.add(new ArrayList<>(row));
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
    
        System.out.println(new Solution().zigzagLevelOrder(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}