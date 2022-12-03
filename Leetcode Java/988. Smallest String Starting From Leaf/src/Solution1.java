public class Solution1 {
    private String min;
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return min;
    }

    public void dfs(TreeNode node, StringBuilder sb) {
        sb.append((char)('a' + node.val));
        if (isLeaf(node)) {
            String s = sb.reverse().toString();
            if (min == null) {
                min = s;
            }
            else if (s.compareTo(min) < 0) {
                min = s;
            }
            return;
        }
        if (node.left != null) {
            dfs(node.left, new StringBuilder(sb));
        }
        if (node.right != null) {
            dfs(node.right, new StringBuilder(sb));
        }
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right== null;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(25);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(2);
        
        System.out.println(new Solution1().smallestFromLeaf(root));
    }
}

