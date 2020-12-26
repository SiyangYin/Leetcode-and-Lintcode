import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution4 {
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            while (cur != null) {
                res.add(cur.val);
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                
                cur = cur.left;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        System.out.println(new Solution().preorderTraversal(root));
    }
}

class TreeNode {
    public int val;
    public TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}
