import java.util.Stack;

public class Solution {
    /*
     * @param stk: an integer stack
     * @return: void
     */
    public void stackSorting(Stack<Integer> stk) {
        // write your code here
        Stack<Integer> aux = new Stack<>();
        while (!stk.isEmpty()) {
            while (aux.isEmpty() || (!stk.isEmpty() && stk.peek() <= aux.peek())) {
                aux.push(stk.pop());
            }
            if (stk.isEmpty()) {
                break;
            }
            
            int top = stk.pop();
            while (!aux.isEmpty() && top > aux.peek()) {
                stk.push(aux.pop());
            }
            aux.push(top);
        }
        
        while (!aux.isEmpty()) {
            stk.push(aux.pop());
        }
    }
    
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(4);
        s.push(2);
        s.push(1);
        s.push(3);
        new Solution().stackSorting(s);
        System.out.println(s);
    }
}
