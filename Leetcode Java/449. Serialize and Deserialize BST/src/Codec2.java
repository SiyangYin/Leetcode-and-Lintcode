import java.util.Arrays;

public class Codec2 {
    private int i = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs1(sb, root);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 2) {
            return null;
        }
        String[] arr = data.split(",");
        TreeNode node = new TreeNode(Integer.parseInt(arr[i++]));
        dfs2(arr, node);
        return node;
    }

    public void dfs1(StringBuilder sb, TreeNode node) {
        if (node != null) {
            sb.append(node.val);
            sb.append(",");
            dfs1(sb, node.left);
            dfs1(sb, node.right);
        }
        else {
            sb.append("#");
            sb.append(",");
        }
    }

    public void dfs2(String[] arr, TreeNode node) {
        if (i < arr.length && !arr[i].equals("#")) {
            node.left = new TreeNode(Integer.parseInt(arr[i++]));
            dfs2(arr, node.left);
        }
        else {
            i++;
        }
        if (i < arr.length && !arr[i].equals("#")) {
            node.right = new TreeNode(Integer.parseInt(arr[i++]));
            dfs2(arr, node.right);
        }
        else {
            i++;
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root = null;
        // root.left = new TreeNode(1);
        // root.right = new TreeNode(3);
        String s = new Codec2().serialize(root);
        System.out.println(s);
        TreeNode node = new Codec2().deserialize(s);
        System.out.println();
    
        System.out.println(Arrays.toString("".split(",")));
    }
}

