public class Solution {
    /**
     * @param s: a string
     * @return: a root of this tree
     */
    public TreeNode str2tree(String s) {
        // write your code here
        if (s == null || s.isEmpty()) {
            return null;
        }
        
        int i = 0;
        while (i < s.length() && s.charAt(i) != '(') {
            i++;
        }
        
        int r = Integer.parseInt(s.substring(0, i));
        TreeNode root = new TreeNode(r);
        
        
        int l = 0;
        boolean left = true;
        for (int j = i; j < s.length(); j++) {
            if (s.charAt(j) == '(') {
                l++;
            } else if (s.charAt(j) == ')') {
                l--;
            }
            
            if (l == 0 && left) {
                root.left = str2tree(s.substring(i + 1, j));
                left = false;
                i = j + 1;
            } else if (l == 0) {
                root.right = str2tree(s.substring(i + 1, j));
            }
        }
        
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = new Solution().str2tree("-4(2(3)(1))(6(5))");
        System.out.println(root);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}