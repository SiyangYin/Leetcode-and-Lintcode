import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    
    class Iterator {
        
        private Deque<TreeNode> stack;
        
        public Iterator(TreeNode root) {
            stack = new LinkedList<>();
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }
        
        public int peek() {
            return stack.peek().val;
        }
        
        public int next() {
            TreeNode cur = stack.pop(), right = cur.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
            
            return cur.val;
        }
        
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        Iterator it1 = new Iterator(root1), it2 = new Iterator(root2);
        while (it1.hasNext() || it2.hasNext()) {
            if (!it1.hasNext()) {
                res.add(it2.next());
            } else if (!it2.hasNext()) {
                res.add(it1.next());
            } else {
                int v1 = it1.peek(), v2 = it2.peek();
                if (v1 < v2) {
                    res.add(it1.next());
                } else if (v1 > v2) {
                    res.add(it2.next());
                } else {
                    res.add(it1.next());
                    res.add(it2.next());
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(2);
        r1.left = new TreeNode(1);
        r1.right = new TreeNode(4);
        
        TreeNode r2 = new TreeNode(1);
        r2.left = new TreeNode(0);
        r2.right = new TreeNode(3);
        
        System.out.println(new Solution().getAllElements(r1, r2));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}