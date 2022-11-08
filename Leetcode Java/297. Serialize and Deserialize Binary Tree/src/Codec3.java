import java.util.LinkedList;
import java.util.Queue;

public class Codec3 {
    private Queue<TreeNode> q = new LinkedList<>();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        q.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                sb.append(node.val);
                sb.append(',');
                q.offer(node.left);
                q.offer(node.right);
            }
            else {
                sb.append('.');
                sb.append(',');
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.offer(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode node = q.poll();
            if (!arr[i].equals(".")) {
                node.left = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(node.left);
            }
            i++;
            if (i < arr.length && !arr[i].equals(".")) {
                node.right = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(node.right);
            }
            i++;
        }
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        
        System.out.println(new Codec3().serialize(root));
        String haha = new Codec3().serialize(root);
        TreeNode ans = new Codec3().deserialize(haha);
        System.out.println(ans.val);
        System.out.println(ans.left.val);
        System.out.println(ans.left.left);
        System.out.println(ans.right.val);
    }
}

