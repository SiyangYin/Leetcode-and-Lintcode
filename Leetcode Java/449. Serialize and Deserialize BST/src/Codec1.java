import java.util.Arrays;

public class Codec1 {
    private int i = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs1(sb, root);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return dfs2(arr);
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

    public TreeNode dfs2(String[] arr) {
        if (i >= arr.length || arr[i].equals("#")) {
            i++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(arr[i++]));
        node.left = dfs2(arr);
        node.right = dfs2(arr);
        return node;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root = null;
        // root.left = new TreeNode(1);
        // root.right = new TreeNode(3);
        String s = new Codec1().serialize(root);
        System.out.println(s);
        TreeNode node = new Codec1().deserialize(s);
        System.out.println();
    
        System.out.println(Arrays.toString("".split(",")));
    }
}

