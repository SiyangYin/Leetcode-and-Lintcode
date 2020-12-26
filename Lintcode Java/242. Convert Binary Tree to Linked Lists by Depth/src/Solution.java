import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        List<ListNode> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
    
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            for (int i = 0; i < size; i++) {
                TreeNode x = queue.poll();
                cur.next = new ListNode(x.val);
                cur = cur.next;
                
                if (x.left != null) {
                    queue.offer(x.left);
                }
                if (x.right != null) {
                    queue.offer(x.right);
                }
            }
            
            lists.add(dummy.next);
        }
        
        return lists;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
    
        List<ListNode> lists = new Solution().binaryTreeToLists(root);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}