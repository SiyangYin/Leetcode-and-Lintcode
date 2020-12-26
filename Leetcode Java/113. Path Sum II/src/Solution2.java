import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        if (root.left == null && root.right == null && root.val == sum) {
            List<Integer> cur = new LinkedList<>();
            cur.add(root.val);
            res.add(cur);
        }
        
        List<List<Integer>> leftPaths = pathSum(root.left, sum - root.val);
        List<List<Integer>> rightPaths = pathSum(root.right, sum - root.val);
    
        for (List<Integer> leftPath : leftPaths) {
            leftPath.add(0, root.val);
            res.add(leftPath);
        }
    
        for (List<Integer> rightPath : rightPaths) {
            rightPath.add(0, root.val);
            res.add(rightPath);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(new Solution2().pathSum(root, 22));
    }
}
