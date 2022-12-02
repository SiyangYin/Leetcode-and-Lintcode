import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CBTInserter2 {
    private TreeNode root;
    private Queue<TreeNode> q;
    public CBTInserter2(TreeNode root) {
        this.root = root;
        q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty() && isFull(q.peek())) {
            TreeNode node = q.poll();
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }
    }

    public boolean isFull(TreeNode node) {
        return node.left != null && node.right != null;
    }

    public int insert(int val) {
        TreeNode node = q.peek();
        if (node.left == null) {
            node.left = new TreeNode(val);
        }
        else {
            node.right = new TreeNode(val);
            q.poll();
            q.offer(node.left);
            q.offer(node.right);
        }
        return node.val;
    }

    public TreeNode get_root() {
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        CBTInserter2 ins = new CBTInserter2(root);
        ins.insert(2);
        ins.insert(3);
        System.out.println(ins.get_root());
    }
}

