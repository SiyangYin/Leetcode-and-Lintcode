import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Stack<List<Integer>> stack = new Stack<>();
        while (!queue.isEmpty()) {
            int curNum = queue.size();
            for (int i = 0; i < curNum; i++) {
                TreeNode x = queue.poll();
                row.add(x.val);
                if (x.left != null) {
                    queue.offer(x.left);
                }
                if (x.right != null) {
                    queue.offer(x.right);
                }
            }
            stack.push(row);
            row = new ArrayList<>();
        }
        while (!stack.isEmpty()) {
            lists.add(stack.pop());
        }
        return lists;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution().levelOrderBottom(root));
        
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}