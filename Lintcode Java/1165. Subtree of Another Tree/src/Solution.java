public class Solution {
    /**
     * @param s: the s' root
     * @param t: the t' root
     * @return: whether tree t has exactly the same structure and node values with a subtree of s
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // Write your code here
        if (t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        
        StringBuilder ss = new StringBuilder(), tt = new StringBuilder();
        serialize(s, ss);
        serialize(t, tt);
        if (ss.length() < tt.length()) {
            return false;
        }
        
        return match(ss, tt);
    }
    
    private boolean match(StringBuilder s, StringBuilder p) {
        int[] next = buildNext(p);
        int i = 0, j = 0;
        while (i < s.length() && j < p.length()) {
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        
        return j == p.length();
    }
    
    private int[] buildNext(StringBuilder p) {
        int[] next = new int[p.length()];
        int i = 0, j = next[0] = -1;
        while (i < p.length() - 1) {
            if (j == -1 || p.charAt(i) == p.charAt(j)) {
                i++;
                j++;
                next[i] = p.charAt(i) == p.charAt(j) ? next[j] : j;
            } else {
                j = next[j];
            }
        }
        
        return next;
    }
    
    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append('#');
            return;
        }
        
        sb.append(root.val).append('_');
        serialize(root.left, sb);
        sb.append('_');
        serialize(root.right, sb);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(5);
        StringBuilder sb = new StringBuilder();
        new Solution().serialize(root, sb);
        System.out.println(sb);
        
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(2);
        StringBuilder sb2 = new StringBuilder();
        new Solution().serialize(root2, sb2);
        System.out.println(sb2);
    
        System.out.println(new Solution().isSubtree(root, root2));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}