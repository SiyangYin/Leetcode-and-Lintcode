import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        return merge(lists, 0, lists.size() - 1);
    }
    
    private ListNode merge(List<ListNode> lists, int l, int r) {
        if (l == r) {
            return lists.get(l);
        }
        
        int m = l + (r - l >> 1);
        ListNode l1 = merge(lists, l, m);
        ListNode l2 = merge(lists, m + 1, r);
        
        ListNode dummy = new ListNode(0), cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        
        cur.next = l1 != null ? l1 : l2;
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        
        ListNode l2 = new ListNode(-1);
        
        List<ListNode> lists = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        ListNode kLists = new Solution2().mergeKLists(lists);
        while (kLists != null) {
            System.out.println(kLists.val);
            kLists = kLists.next;
        }
    }
}
