import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
    public Node connect(Node root) {
        if (root == null) return root;
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
            connect(root.left);
            connect(root.right);
        }
        return root;
    }
}

