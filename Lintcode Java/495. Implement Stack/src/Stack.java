public class Stack {
    
    int[] stack = new int[10];
    int size = 0;
    
    /*
     * @param x: An integer
     * @return: nothing
     */
    public void push(int x) {
        // write your code here
        if (size == stack.length) {
            resize(stack.length * 2);
        }
        
        stack[size++] = x;
    }
    
    /*
     * @return: nothing
     */
    public void pop() {
        // write your code here
        size--;
        if (size <= stack.length / 4 && stack.length / 4 > 0) {
            resize(stack.length / 2);
        }
    }
    
    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        return stack[size - 1];
    }
    
    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        // write your code here
        return size == 0;
    }
    
    private void resize(int newCapacity) {
        int[] tmp = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            tmp[i] = stack[i];
        }
        
        stack = tmp;
    }
    
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.pop();
        stack.push(2);
        
    }
}