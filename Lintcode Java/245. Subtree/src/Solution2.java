public class Solution2 {
    /**
     * @param T1: The roots of binary tree T1.
     * @param T2: The roots of binary tree T2.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
        if (T1 == null) {
            return T2 == null;
        }
        if (T2 == null) {
            return true;
        }
        
        StringBuilder t1 = new StringBuilder(), t2 = new StringBuilder();
        serialize(T1, t1);
        serialize(T2, t2);
        return match(t1, t2);
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
            return;
        }
        
        sb.append(root.val);
        if (root.left== null && root.right == null) {
            return;
        }
        
        sb.append('(');
        serialize(root.left, sb);
        sb.append(')');
        if (root.right != null) {
            sb.append('(');
            serialize(root.right, sb);
            sb.append(')');
        }
    }
    
    public static void main(String[] args) {
        // TreeNode r1 = new TreeNode(1);
        // r1.left = new TreeNode(2);
        // r1.right = new TreeNode(3);
        // r1.right.left = new TreeNode(4);
        //
        // TreeNode r2 = new TreeNode(3);
        // r2.left = new TreeNode(4);
        TreeNode r1 = null;
        TreeNode r2 = null;
        System.out.println(new Solution2().isSubtree(r1, r2));
    }
}
