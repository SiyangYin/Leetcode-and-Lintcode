public class ThreeStacks {
    
    class Node {
        Node prev, next;
        int idx, val;
        
        public Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
    
    private Node[] stack;
    // 记录每个stack的栈顶位置
    private int[] tops;
    // 记录已经用到的空间个数
    private int used;
    
    /*
     * @param size: An integer
     */
    public ThreeStacks(int size) {
        // do intialization if necessary
        stack = new Node[size * 3];
        tops = new int[]{-1, -1, -1};
    }
    
    /*
     * @param stackNum: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void push(int stackNum, int value) {
        // Push value into stackNum stack
        int top = tops[stackNum];
        if (top == -1) {
            stack[used] = new Node(value, used);
            tops[stackNum] = used;
            used++;
        } else {
            Node topNode = stack[top];
            if (topNode.next == null) {
                stack[used] = new Node(value, used);
                topNode.next = stack[used];
                topNode.next.prev = topNode;
                tops[stackNum] = used;
                used++;
            } else {
                topNode.next.val = value;
                tops[stackNum] = topNode.next.idx;
            }
        }
        
    }
    
    /*
     * @param stackNum: An integer
     * @return: the top element
     */
    public int pop(int stackNum) {
        // Pop and return the top element from stackNum stack
        int top = tops[stackNum];
        Node topNode = stack[top];
        int res = topNode.val;
        if (topNode.prev == null) {
            tops[stackNum] = -1;
        } else {
            tops[stackNum] = topNode.prev.idx;
        }
        
        return res;
    }
    
    /*
     * @param stackNum: An integer
     * @return: the top element
     */
    public int peek(int stackNum) {
        // Return the top element
        return stack[tops[stackNum]].val;
    }
    
    /*
     * @param stackNum: An integer
     * @return: true if the stack is empty else false
     */
    public boolean isEmpty(int stackNum) {
        // write your code here
        return tops[stackNum] == -1;
    }
    
    public static void main(String[] args) {
        ThreeStacks stacks = new ThreeStacks(3);
        stacks.push(0, 10);
        stacks.push(0, 11);
        stacks.push(1, 20);
        stacks.push(1, 1);
        stacks.push(1, 12);
        stacks.push(0, 2);
        stacks.push(2, 31);
        stacks.push(2, 41);
        stacks.push(2, 241);
        // System.out.println(stacks.pop(0));
        // System.out.println(stacks.pop(1));
        // stacks.push(2, 30);
        // stacks.pop(2);
        // System.out.println(stacks.isEmpty(2));
        // System.out.println(stacks.isEmpty(0));
    }
}