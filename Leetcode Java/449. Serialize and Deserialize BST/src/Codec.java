import java.util.Arrays;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }
    
    private void dfs(TreeNode cur, StringBuilder sb) {
        if (cur == null) {
            return;
        }
        
        sb.append(cur.val).append(',');
        dfs(cur.left, sb);
        dfs(cur.right, sb);
    }
    
    private int idx;
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        
        String[] strs = data.split(",");
        idx = 0;
        return dfs(strs, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode dfs(String[] strs, int min, int max) {
        if (idx == strs.length) {
            return null;
        }
    
        int val = Integer.parseInt(strs[idx]);
        if (min < val && val < max) {
            idx++;
            
            TreeNode cur = new TreeNode(val);
            cur.left = dfs(strs, min, val);
            cur.right = dfs(strs, val, max);
            return cur;
        } else {
            return null;
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root = null;
        // root.left = new TreeNode(1);
        // root.right = new TreeNode(3);
        String s = new Codec().serialize(root);
        System.out.println(s);
        TreeNode node = new Codec().deserialize(s);
        System.out.println();
    
        System.out.println(Arrays.toString("".split(",")));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}