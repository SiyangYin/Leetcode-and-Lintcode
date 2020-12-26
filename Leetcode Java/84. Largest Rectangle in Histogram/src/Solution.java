import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    
    class Node {
        int val;
        Node left, right;
        
        public Node(int val) {
            this.val = val;
        }
    }
    
    private int res;
    
    public int largestRectangleArea(int[] heights) {
        Node root = buildCartesianTree(heights);
        dfs(root);
        return res;
    }
    
    private int dfs(Node root) {
        if (root == null) {
            return 0;
        }
        
        int l = dfs(root.left), r = dfs(root.right);
        res = Math.max(res, (r + l + 1) * root.val);
        
        return 1 + l + r;
    }
    
    private Node buildCartesianTree(int[] nums) {
        Deque<Node> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            Node last = null;
            while (!stack.isEmpty() && stack.peek().val > nums[i]) {
                last = stack.pop();
            }
            
            Node cur = new Node(nums[i]);
            cur.left = last;
            if (!stack.isEmpty()) {
                stack.peek().right = cur;
            }
            stack.push(cur);
        }
        
        return stack.peekLast();
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(new Solution().largestRectangleArea(new int[]{999, 999, 999, 999}));
    }
}
