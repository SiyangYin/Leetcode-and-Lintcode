import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param root: a binary tree
     * @param sum: the sum
     * @return: the scheme
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        // Write your code here.
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        return pathSumHelper(root, sum, lists, new ArrayList<Integer>());
        
    }
    
    public List<List<Integer>> pathSumHelper(TreeNode root, int sum, List<List<Integer>> lists, List<Integer> curPath) {
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                curPath.add(root.val);
                lists.add((List<Integer>) ((ArrayList) curPath).clone());
                curPath.remove(curPath.size() - 1);
            }
            return lists;
        }
        
        curPath.add(root.val);
        if (root.left != null) {
            pathSumHelper(root.left, sum - root.val, lists, curPath);
        }
        if (root.right != null) {
            pathSumHelper(root.right, sum - root.val, lists, curPath);
        }
        curPath.remove(curPath.size() - 1);
        return lists;
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
        System.out.println(new Solution().pathSum(root, 22));
    }
}

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
