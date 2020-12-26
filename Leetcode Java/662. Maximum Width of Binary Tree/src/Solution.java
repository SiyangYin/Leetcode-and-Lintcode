import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    
    class Pair {
        TreeNode node;
        int idx;
    
        public Pair(TreeNode node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int res = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            int left = 0, right = 0;
            for (int i = 0; i < size; i++) {
                Pair cur = queue.poll();
                if (i == 0) {
                    left = cur.idx;
                }
                if (i == size - 1) {
                    right = cur.idx;
                    res = Math.max(res, right - left + 1);
                }
                
                if (cur.node.left != null) {
                    queue.offer(new Pair(cur.node.left, cur.idx * 2 + 1));
                }
                if (cur.node.right != null) {
                    queue.offer(new Pair(cur.node.right, cur.idx * 2 + 2));
                }
            }
        }
        
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}