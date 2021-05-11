import java.util.HashSet;
import java.util.Set;

public class FindElements {
    
    private TreeNode root;
    private Set<Integer> set;
    
    public FindElements(TreeNode root) {
        this.root = root;
        set = new HashSet<>();
        recover(this.root, 0);
    }
    
    private void recover(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        
        set.add(val);
        root.val = val;
        recover(root.left, val * 2 + 1);
        recover(root.right, val * 2 + 2);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}