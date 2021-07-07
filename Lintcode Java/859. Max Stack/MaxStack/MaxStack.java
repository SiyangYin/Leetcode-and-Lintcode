import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class MaxStack {
    
    class Node {
        int val;
        Node prev, next;
    
        public Node(int val) {
            this.val = val;
        }
    }
    
    private Node head, tail;
    private TreeMap<Integer, List<Node>> treeMap;
    
    public MaxStack() {
        // do intialization if necessary
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        treeMap = new TreeMap<>();
    }
    
    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int x) {
        // write your code here
        Node node = tail.prev;
        node.next = new Node(x);
        node.next.prev = node;
        node.next.next = tail;
        tail.prev = node.next;
        
        treeMap.putIfAbsent(x, new ArrayList<>());
        treeMap.get(x).add(tail.prev);
    }
    
    public int pop() {
        // write your code here
        tail = tail.prev;
        tail.next = null;
        int val = tail.val;
    
        List<Node> list = treeMap.get(val);
        list.remove(list.size() - 1);
        if (list.isEmpty()) {
            treeMap.remove(val);
        }
        return val;
    }
    
    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        return tail.prev.val;
    }
    
    /*
     * @return: An integer
     */
    public int peekMax() {
        // write your code here
        return treeMap.lastKey();
    }
    
    /*
     * @return: An integer
     */
    public int popMax() {
        // write your code here
        int x = treeMap.lastKey();
        List<Node> list = treeMap.get(x);
        Node node = list.remove(list.size() - 1);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        if (list.isEmpty()) {
            treeMap.remove(x);
        }
        
        return x;
    }
    
    public static void main(String[] args) {
        MaxStack stack = new MaxStack();
        stack.push(430);
        System.out.println(stack.popMax());
        stack.push(234);
        System.out.println(stack.top());
        System.out.println(stack.popMax());
    }
}