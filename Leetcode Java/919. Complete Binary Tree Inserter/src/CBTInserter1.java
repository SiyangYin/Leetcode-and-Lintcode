import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CBTInserter1 {
    private TreeNode root;
    private int cnt;
    public CBTInserter1(TreeNode root) {
        this.root = root;
        dfs(root);
    }

    public void dfs(TreeNode node) {
        if (node != null) {
            cnt++;
            dfs(node.left);
            dfs(node.right);
        }
    }

    public int insert(int val) {
        cnt++;
        int parent = cnt / 2;
        List<Integer> list = new LinkedList<>();
        while (parent > 1) {
            list.add(0, parent % 2);
            parent /= 2;
        }
        TreeNode p = root;
        for (int i : list) {
            if (i == 0) {
                p = p.left;
            }
            else {
                p = p.right;
            }
        }
        if (p.left == null) {
            p.left = new TreeNode(val);
        }
        else {
            p.right = new TreeNode(val);
        }
        return p.val;
    }

    public TreeNode get_root() {
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        CBTInserter1 ins = new CBTInserter1(root);
        ins.insert(2);
        ins.insert(3);
        System.out.println(ins.get_root());
    }
}

