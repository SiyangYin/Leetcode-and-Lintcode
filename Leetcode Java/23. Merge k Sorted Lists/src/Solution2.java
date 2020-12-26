import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
    
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                heap.offer(lists[i]);
            }
        }
        
        while (!heap.isEmpty()) {
            ListNode min = heap.poll();
            cur.next = min;
            if (min.next != null) {
                heap.offer(min.next);
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
        ListNode res = new Solution2().mergeKLists(lists);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
        
    }
}
