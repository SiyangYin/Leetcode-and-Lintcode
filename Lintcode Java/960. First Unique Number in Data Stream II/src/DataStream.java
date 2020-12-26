import java.util.HashMap;
import java.util.Map;

public class DataStream {
    
    class ListNode {
        int val;
        ListNode prev, next;
        
        public ListNode(int val) {
            this.val = val;
        }
    }
    
    private ListNode dummy, tail;
    private Map<Integer, ListNode> map;
    
    public DataStream() {
        // do intialization if necessary
        map = new HashMap<>();
        dummy = tail = new ListNode(0);
    }
    
    /**
     * @param num: next number in stream
     * @return: nothing
     */
    public void add(int num) {
        // write your code here
        if (map.containsKey(num)) {
            if (map.get(num) == null) {
                return;
            }
            
            ListNode node = map.get(num);
            map.put(num, null);
            node.prev.next = node.next;
            if (node.next != null) {
                node.next.prev = node.prev;
            } else {
                tail = node.prev;
            }
            
            return;
        }
        
        tail.next = new ListNode(num);
        tail.next.prev = tail;
        tail = tail.next;
        map.put(num, tail);
    }
    
    /**
     * @return: the first unique number in stream
     */
    public int firstUnique() {
        // write your code here
        return dummy.next.val;
    }
    
    public static void main(String[] args) {
        DataStream s = new DataStream();
        s.add(1);
        s.add(2);
        System.out.println(s.firstUnique());
        s.add(1);
        System.out.println(s.firstUnique());
    }
}