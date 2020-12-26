public class Solution {
    
    private String res;
    
    public String smallestFromLeaf(TreeNode root) {
        res = "";
        if (root == null) {
            return res;
        }
        
        dfs(root, new StringBuilder());
        return res;
    }
    
    private void dfs(TreeNode cur, StringBuilder sb) {
        sb.append((char) ('a' + cur.val));
        if (cur.left == null && cur.right == null) {
            if (res.isEmpty() | res.compareTo(sb.reverse().toString()) > 0) {
                res = sb.toString();
            }
            
            sb.reverse();
            return;
        }
        
        if (cur.left != null) {
            dfs(cur.left, sb);
            sb.setLength(sb.length() - 1);
        }
        
        if (cur.right != null) {
            dfs(cur.right, sb);
            sb.setLength(sb.length() - 1);
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(25);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(2);
        
        System.out.println(new Solution().smallestFromLeaf(root));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}