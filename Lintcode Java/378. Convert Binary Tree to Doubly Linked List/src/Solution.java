public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {
        // write your code here
        if (root == null) {
            return null;
        }
        
        DoublyListNode mid = new DoublyListNode(root.val);
        DoublyListNode leftHead = bstToDoublyList(root.left), rightHead = bstToDoublyList(root.right);
        
        mid.next = rightHead;
        if (rightHead != null) {
            rightHead.prev = mid;
        }
        
        if (leftHead == null) {
            return mid;
        }
        
        DoublyListNode cur = leftHead;
        while (cur.next != null) {
            cur = cur.next;
        }
        
        cur.next = mid;
        mid.prev = cur;
        
        return leftHead;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);
        DoublyListNode head = new Solution().bstToDoublyList(root);
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

class DoublyListNode {
    int val;
    DoublyListNode next, prev;
    
    public DoublyListNode(int val) {
        this.val = val;
    }
}