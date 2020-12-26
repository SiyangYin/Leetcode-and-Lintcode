import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public TreeNode str2tree(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        
        Deque<TreeNode> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)) || s.charAt(i) == '-') {
                int j = i;
                while (j < s.length() && (Character.isDigit(s.charAt(j)) || s.charAt(j) == '-')) {
                    j++;
                }
                
                int val = Integer.parseInt(s.substring(i, j));
                i = j - 1;
                TreeNode node = new TreeNode(val);
                if (!stack.isEmpty()) {
                    if (stack.peek().left == null) {
                        stack.peek().left = node;
                    } else {
                        stack.peek().right = node;
                    }
                    
                }
                stack.push(node);
            } else if (s.charAt(i) == ')') {
                stack.pop();
            }
        }
        
        return stack.peek();
    }
    
    public static void main(String[] args) {
        TreeNode treeNode = new Solution().str2tree("4(2(-3)(1))(6(5))");
        System.out.println();
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}