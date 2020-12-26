import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        addLargest(root, 0, res);
        return res;
    }
    
    private void addLargest(TreeNode root, int depth, List<Integer> res) {
        if (root == null) {
            return;
        }
        
        if (depth == res.size()) {
            res.add(root.val);
        } else {
            res.set(depth, Math.max(root.val, res.get(depth)));
        }
        
        addLargest(root.left, depth + 1, res);
        addLargest(root.right, depth + 1, res);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
    
        System.out.println(new Solution2().largestValues(root));
    }
}
