import java.util.LinkedList;
import java.util.Queue;

public class CBTInserter {
    
    private TreeNode root;
    private Queue<TreeNode> queue;
    
    public CBTInserter(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur.left == null || cur.right == null) {
                queue.offer(cur);
            }
            
            if (cur.left != null) {
                q.offer(cur.left);
            }
            if (cur.right != null) {
                q.offer(cur.right);
            }
        }
    }
    
    public int insert(int v) {
        TreeNode head = queue.peek(), node = new TreeNode(v);
        if (head.left == null) {
            head.left = node;
        } else {
            head.right = node;
            queue.poll();
        }
        
        queue.offer(node);
        return head.val;
    }
    
    public TreeNode get_root() {
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        CBTInserter ins = new CBTInserter(root);
        ins.insert(2);
        ins.insert(3);
        System.out.println(ins.get_root());
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int x) {
        val = x;
    }
}