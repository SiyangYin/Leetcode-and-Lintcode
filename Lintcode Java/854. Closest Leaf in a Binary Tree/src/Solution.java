import java.util.*;

public class Solution {
    /**
     * @param root: the root
     * @param k:    an integer
     * @return: the value of the nearest leaf node to target k in the tree
     */
    public int findClosestLeaf(TreeNode root, int k) {
        // Write your code here
        Map<TreeNode, TreeNode> par = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode nodek = null;
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur.val == k) {
                nodek = cur;
            }
            
            if (cur.left != null) {
                par.put(cur.left, cur);
                q.offer(cur.left);
            }
            if (cur.right != null) {
                par.put(cur.right, cur);
                q.offer(cur.right);
            }
        }
        
        q.offer(nodek);
        Set<TreeNode> set = new HashSet<>();
        set.add(nodek);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                continue;
            }
            
            if (cur.left == null && cur.right == null) {
                return cur.val;
            }
            
            if (cur.left != null && !set.contains(cur.left)) {
                q.offer(cur.left);
                set.add(cur.left);
            }
            if (cur.right != null && !set.contains(cur.right)) {
                q.offer(cur.right);
                set.add(cur.right);
            }
            if (par.containsKey(cur) && !set.contains(par.get(cur))) {
                q.offer(par.get(cur));
                set.add(par.get(cur));
            }
        }
        
        return -1;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}