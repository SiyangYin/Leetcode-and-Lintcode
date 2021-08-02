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
                boolean flag = false;
                if (cur.left != null) {
                    queue.offer(cur.left);
                    if (!map.containsKey(cur.left)) {
                        map.put(cur.left, cur);
                    } else {
                        flag = true;
                    }
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    if (!map.containsKey(cur.right)) {
                        map.put(cur.right, cur);
                    } else {
                        flag = true;
                    }
                }
                
                if (flag) {
                    remove(map, cur);
                    return root;
                }
            }
        }
        
        return root;
    }
    
    private void remove(Map<TreeNode, TreeNode> parent, TreeNode cur) {
        TreeNode p = parent.get(cur);
        if (cur == p.left) {
            p.left = null;
        } else {
            p.right = null;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}