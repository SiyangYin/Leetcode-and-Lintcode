import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
    
    class Node {
        int val, idx;
        Node left, right;
        
        public Node(int val) {
            this.val = val;
        }
        
        public Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
    
    private int res;
    
    
    // 错的，做不出来
    public int trap(int[] height) {
        Node root = buildCartesianTree(height);
        dfs(root);
        return res;
    }
    
    private int dfs(Node root) {
        if (root == null) {
            return 0;
        }
        
        int l = dfs(root.left), r = dfs(root.right);
        res += Math.max(Math.min(l, r) - root.val,0);
        
        return Math.max(Math.max(l, r), root.val);
    }
    
    private Node buildCartesianTree(int[] height) {
        Deque<Node> stack = new LinkedList<>();
        for (int i = 0; i < height.length; i++) {
            Node last = null;
            while (!stack.isEmpty() && stack.peek().val > height[i]) {
                last = stack.pop();
            }
            
            Node cur = new Node(height[i], i);
            cur.left = last;
            if (!stack.isEmpty()) {
                stack.peek().right = cur;
            }
            stack.push(cur);
        }
        
        return stack.peekLast();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().trap(new int[]{2, 0, 1, 3}));
        // System.out.println(new Solution2().trap(new int[]{3, 1, 2}));
        // System.out.println(new Solution2().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
