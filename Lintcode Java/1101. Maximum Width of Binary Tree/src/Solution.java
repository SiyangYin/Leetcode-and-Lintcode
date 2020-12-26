import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * @param root: the root
     * @return: the maximum width of the given tree
     */
    public int widthOfBinaryTree(TreeNode root) {
        // Write your code here
        if (root == null) {
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);
        
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode x = queue.poll();
                int num = deque.poll();
                if (x.left != null) {
                    queue.offer(x.left);
                    deque.offer(2 * num + 1);
                }
                if (x.right != null) {
                    queue.offer(x.right);
                    deque.offer(2 * num + 2);
                }
            }
            if (!deque.isEmpty()) {
                res = Math.max(res, deque.peekLast() - deque.peekFirst() + 1);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
    
        System.out.println(new Solution().widthOfBinaryTree(root));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}