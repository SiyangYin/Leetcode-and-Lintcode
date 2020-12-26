public class Codec2 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        
        if (sb.charAt(sb.length() - 1) == ',') {
            sb.setLength(sb.length() - 1);
        }
        
        return sb.toString();
    }
    
    private void dfs(TreeNode cur, StringBuilder sb) {
        if (cur == null) {
            sb.append("#,");
            return;
        }
        
        sb.append(cur.val).append(',');
        dfs(cur.left, sb);
        dfs(cur.right, sb);
    }
    
    private int idx;
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        idx = 0;
        return dfs(strs);
    }
    
    private TreeNode dfs(String[] strs) {
        if (strs[idx].equals("#")) {
            idx++;
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.parseInt(strs[idx++]));
        node.left = dfs(strs);
        node.right = dfs(strs);
        return node;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        
        String s = new Codec2().serialize(root);
        System.out.println(s);
    
        TreeNode node = new Codec2().deserialize(s);
        System.out.println();
    }
}
