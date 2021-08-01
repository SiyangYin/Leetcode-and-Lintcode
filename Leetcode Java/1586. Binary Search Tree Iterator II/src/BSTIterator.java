import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BSTIterator {
    
    private Deque<TreeNode> stk;
    private List<TreeNode> list;
    private int pos;
    
    public BSTIterator(TreeNode root) {
        pos = -1;
        list = new ArrayList<>();
        stk = new LinkedList<>();
        while (root != null) {
            stk.push(root);
            root = root.left;
        }
    }
    
    public boolean hasNext() {
        return !stk.isEmpty() || pos + 1 < list.size();
    }
    
    public int next() {
        pos++;
        if (pos < list.size()) {
            return list.get(pos).val;
        }
        
        TreeNode top = stk.pop(), right = top.right;
        list.add(top);
        while (right != null) {
            stk.push(right);
            right = right.left;
        }
        
        return top.val;
    }
    
    public boolean hasPrev() {
        return pos > 0;
    }
    
    public int prev() {
        return list.get(--pos).val;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        BSTIterator it = new BSTIterator(root);
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.prev());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.hasPrev());
        System.out.println(it.prev());
        System.out.println(it.prev());
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}
