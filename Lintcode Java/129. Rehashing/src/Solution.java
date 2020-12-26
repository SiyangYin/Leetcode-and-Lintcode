import java.util.Arrays;

public class Solution {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        int newCapacity = hashTable.length * 2;
        ListNode[] res = new ListNode[newCapacity];
    
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null) {
                ListNode head = hashTable[i];
                while (head != null) {
                    insert(res, head.val);
                    head = head.next;
                }
            }
        }
        
        return res;
    }
    
    private void insert(ListNode[] hashTable, int val) {
        int pos = (val + hashTable.length) % hashTable.length;
        if (hashTable[pos] == null) {
            hashTable[pos] = new ListNode(val);
        } else {
            ListNode head = hashTable[pos];
            while (head.next != null) {
                head = head.next;
            }
            head.next = new ListNode(val);
        }
    }
    
    public static void main(String[] args) {
        ListNode[] hashTable = new ListNode[3];
        hashTable[2] = new ListNode(29);
        hashTable[2].next = new ListNode(5);
        
        ListNode[] res = new Solution().rehashing(hashTable);
        System.out.println(Arrays.toString(res));
        System.out.println(res[5].val);
        System.out.println(res[5].next.val);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}