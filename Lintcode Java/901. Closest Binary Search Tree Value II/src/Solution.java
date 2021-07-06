import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    /**
     * @param root:   the given BST
     * @param target: the given target
     * @param k:      the given k
     * @return: k values in the BST that are closest to the target
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (root == null || k == 0) {
            return res;
        }
        
        Deque<TreeNode> stkLeft = new LinkedList<>(), stkRight = new LinkedList<>();
        fillStk(root, stkLeft, target);
        stkRight.addAll(stkLeft);
        
        if (target < stkLeft.peek().val) {
            moveLeft(stkLeft);
        } else {
            moveRight(stkRight);
        }
    
        for (int i = 0; i < k; i++) {
            if (stkLeft.isEmpty()) {
                res.add(stkRight.peek().val);
                moveRight(stkRight);
            } else if (stkRight.isEmpty()) {
                res.add(stkLeft.peek().val);
                moveLeft(stkLeft);
            } else {
                int valLeft = stkLeft.peek().val, valRight = stkRight.peek().val;
                if (target - valLeft <= valRight - target) {
                    res.add(valLeft);
                    moveLeft(stkLeft);
                } else {
                    res.add(valRight);
                    moveRight(stkRight);
                }
            }
        }
        
        return res;
    }
    
    private void moveRight(Deque<TreeNode> stk) {
        TreeNode cur = stk.peek();
        if (cur.right == null) {
            stk.pop();
            while (!stk.isEmpty() && stk.peek().right == cur) {
                cur = stk.pop();
            }
        } else {
            cur = cur.right;
            while (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
        }
    }
    
    private void moveLeft(Deque<TreeNode> stk) {
        TreeNode cur = stk.peek();
        if (cur.left == null) {
            stk.pop();
            while (!stk.isEmpty() && stk.peek().left == cur) {
                cur = stk.pop();
            }
        } else {
            cur = cur.left;
            while (cur != null) {
                stk.push(cur);
                cur = cur.right;
            }
        }
    }
    
    private void fillStk(TreeNode cur, Deque<TreeNode> stk, double target) {
        while (cur != null) {
            stk.push(cur);
            if (target < cur.val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
    
        System.out.println(new Solution().closestKValues(root, 0.5, 2));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int x) {
        val = x;
    }
}