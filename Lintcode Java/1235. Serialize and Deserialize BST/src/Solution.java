import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public String serialize(TreeNode root) {
        // write your code here
        if (root == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        sb.setLength(sb.length() - 1);
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
    
    public TreeNode deserialize(String data) {
        // write your code here
        String[] strs = data.split(",");
        if (strs.length == 0 || strs[0].isEmpty()) {
            return null;
        }
        
        Deque<TreeNode> stack = new LinkedList<>();
    
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        stack.push(root);
        for (int i = 1; i < strs.length; i++) {
            int cur = Integer.parseInt(strs[i]);
            
            if (stack.isEmpty() || stack.peek().val > cur) {
                TreeNode node = new TreeNode(cur);
                if (!stack.isEmpty()) {
                    stack.peek().left = node;
                }
                
                stack.push(node);
            } else {
                TreeNode node = null;
                while (!stack.isEmpty() && stack.peek().val < cur) {
                    node = stack.pop();
                }
                
                node.right = new TreeNode(cur);
                stack.push(node.right);
            }
        }
        
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
    
        root = null;
        String des = new Solution().serialize(root);
        TreeNode node = new Solution().deserialize(des);
        System.out.println(node);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}