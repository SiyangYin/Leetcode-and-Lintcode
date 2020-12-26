import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    /**
     * @param root: the given tree
     * @return: the tree after swapping
     */
    public TreeNode bstSwappedNode(TreeNode root) {
        // write your code here
        TreeNode swap1 = null, swap2 = null;
        TreeNode cur = root, last = null;
        boolean first = true;
        Deque<TreeNode> stack = new LinkedList<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            
            cur = stack.pop();
            if (last != null) {
                if (cur.val < last.val && first) {
                    swap1 = last;
                    swap2 = cur;
                    first = false;
                } else if (cur.val < last.val) {
                    swap2 = cur;
                }
            }
            
            last = cur;
            cur = cur.right;
        }
        
        if (swap1 != null) {
            int tmp = swap1.val;
            swap1.val = swap2.val;
            swap2.val = tmp;
        }
        
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(5);
        // root.left.left = new TreeNode(1);
        // root.left.right = new TreeNode(3);
        // root.right = new TreeNode(2);
        TreeNode r = new Solution().bstSwappedNode(root);
        System.out.println(r);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}