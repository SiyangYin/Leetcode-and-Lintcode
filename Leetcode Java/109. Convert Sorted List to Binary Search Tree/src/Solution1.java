import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    private Set<ListNode> set = new HashSet<>();
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode mid = findMid(head);
        TreeNode root = new TreeNode(mid.val);
        set.add(mid);
        dfs(head, mid, root);
        return root;
    }

    public void dfs(ListNode head, ListNode mid1, TreeNode root) {
        ListNode next = mid1.next;
        mid1.next = null;
        ListNode mid2 = findMid(head);
        ListNode mid3 = findMid(next);
        if (mid2 != null && !set.contains(mid2)) {
            root.left = new TreeNode(mid2.val);
            set.add(mid2);
            dfs(head, mid2, root.left);
        }
        if (mid3 != null && !set.contains(mid3)) {
            root.right = new TreeNode(mid3.val);
            set.add(mid3);
            dfs(next, mid3, root.right);
        }
    }

    public ListNode findMid(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        // head.next.next.next = new ListNode(5);
        // head.next.next.next.next = new ListNode(9);
        // head.next.next.next.next.next = new ListNode(10);
        // head.next.next.next.next.next.next = new ListNode(11);
        
        TreeNode root = new Solution1().sortedListToBST(head);
        System.out.println(root.val);
    }
}

