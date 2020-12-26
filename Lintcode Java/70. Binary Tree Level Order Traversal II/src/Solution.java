import java.util.*;

public class Solution {
    /**
     * @param root: A tree
     * @return: buttom-up level order a list of lists of integer
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> row = new ArrayList<>();
            
            for (int i = 0; i < len; i++) {
                TreeNode x = queue.poll();
                row.add(x.val);
                if (x.left != null) {
                    queue.offer(x.left);
                }
                if (x.right != null) {
                    queue.offer(x.right);
                }
            }
            lists.add(row);
        }
        
        Collections.reverse(lists);
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