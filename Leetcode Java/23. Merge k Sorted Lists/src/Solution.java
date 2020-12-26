public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }
    
    private ListNode merge(ListNode[] lists, int start, int end) {
        if (end <= start) {
            return lists[start];
        }
        
        int mid = start + ((end - start) >> 1);
        ListNode l1 = merge(lists, start, mid);
        ListNode l2 = merge(lists, mid + 1, end);
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                cur.next = l2;
                break;
            }
            if (l2 == null) {
                cur.next = l1;
                break;
            }
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        
        ListNode[] lists = {l1, l2, l3};
        ListNode res = new Solution().mergeKLists(lists);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
        
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}