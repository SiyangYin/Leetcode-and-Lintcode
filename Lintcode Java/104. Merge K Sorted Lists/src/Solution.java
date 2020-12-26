import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        ListNode dummy = new ListNode(0), cur = dummy;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((n1, n2) -> n1.val <= n2.val ? -1 : 1);
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }
        
        while (!minHeap.isEmpty()) {
            ListNode min = minHeap.poll();
            cur.next = min;
            cur = cur.next;
            if (min.next != null) {
                minHeap.offer(min.next);
            }
        }
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);

        ListNode l2 = new ListNode(-1);

        List<ListNode> lists = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        ListNode kLists = new Solution().mergeKLists(lists);
        while (kLists != null) {
            System.out.println(kLists.val);
            kLists = kLists.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}