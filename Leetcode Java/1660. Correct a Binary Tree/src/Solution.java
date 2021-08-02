import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    public TreeNode correctBinaryTree(TreeNode root) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            for (int i = queue.size() - 1; i >= 0; i--) {
                TreeNode cur = queue.poll();
                if (map.containsKey(cur.left) || map.containsKey(cur.right)) {
                    TreeNode p = map.get(cur);
                    if (cur == p.left) {
                        p.left = null;
                    } else {
                        p.right = null;
                    }
                    
                    return root;
                }
                
                if (cur.left != null) {
                    queue.offer(cur.left);
                    map.put(cur.left, cur);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    map.put(cur.right, cur);
                }
            }
        }
        
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}