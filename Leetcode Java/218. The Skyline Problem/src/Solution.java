import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    
    class Node {
        int st, ed, h;
        Node left, right;
        
        public Node(int st, int ed, int h) {
            this.st = st;
            this.ed = ed;
            this.h = h;
        }
    }
    
    void pushup(Node cur) {
        if (cur.left != null && cur.right != null) {
            if (cur.left.left == null && cur.right.left == null && cur.left.h == cur.right.h) {
                cur.h = cur.left.h;
                cur.left = cur.right = null;
            }
        }
    }
    
    void update(Node root, int st, int ed, int h) {
        if (root == null) {
            return;
        }
        
        if (root.st > ed || root.ed < st) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            if (st <= root.st && root.ed <= ed) {
                root.h = Math.max(root.h, h);
                return;
            }
            
            // root.st, st - 1    st, root.ed
            if (root.st < st) {
                root.left = new Node(root.st, st - 1, root.h);
                root.right = new Node(st, root.ed, root.h);
                update(root.right, st, ed, h);
            } else {
                root.left = new Node(root.st, ed, root.h);
                root.right = new Node(ed + 1, root.ed, root.h);
                update(root.left, st, ed, h);
            }
        } else {
            update(root.left, st, ed, h);
            update(root.right, st, ed, h);
        }
        
        pushup(root);
    }
    
    Node root;
    int last;
    
    void dfs(Node cur, List<List<Integer>> res) {
        if (cur == null) {
            return;
        }
        
        dfs(cur.left, res);
        if (cur.left == null && cur.right == null && cur.h != last) {
            res.add(Arrays.asList(cur.st, cur.h));
            last = cur.h;
        }
        dfs(cur.right, res);
    }
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        root = new Node(0, Integer.MAX_VALUE, 0);
        for (int[] b : buildings) {
            update(root, b[0], b[1] - 1, b[2]);
        }
        
        dfs(root, res);
        return res;
    }
    
    public static void main(String[] args) {
        int[][] b = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        System.out.println(new Solution().getSkyline(b));
    }
}