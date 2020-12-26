public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
    
        return mergeSort(head);
    }
    
    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode l1 = head;
        ListNode mid = findMid(head);
        ListNode l2 = mid.next;
        mid.next = null;
    
        ListNode list1 = mergeSort(l1);
        ListNode list2 = mergeSort(l2);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                cur.next = list2;
                break;
            }
            if (list2 == null) {
                cur.next = list1;
                break;
            }
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
    
    private ListNode findMid(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        
        ListNode res = new Solution().sortList(head);
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