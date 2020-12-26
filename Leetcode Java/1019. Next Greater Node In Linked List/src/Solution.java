import java.util.*;

public class Solution {
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return new int[0];
        }
    
        List<Integer> list = new ArrayList<>();
        Deque<Integer> stack = new LinkedList<>();
        
        int ind = 0;
        while (head != null) {
            list.add(head.val);
            while (!stack.isEmpty() && list.get(stack.peek()) < head.val) {
                list.set(stack.pop(), head.val);
            }
            stack.push(ind++);
            head = head.next;
        }
        
        while (!stack.isEmpty()) {
            list.set(stack.pop(), 0);
        }
        
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(5);
    
        System.out.println(Arrays.toString(new Solution().nextLargerNodes(head)));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}