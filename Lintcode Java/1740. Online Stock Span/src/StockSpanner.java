import java.util.ArrayDeque;
import java.util.Deque;

public class StockSpanner {
    
    private Deque<int[]> stack;
    private int idx;
    
    public StockSpanner() {
        stack = new ArrayDeque<>();
    }
    
    /**
     * @param price:
     * @return: int
     */
    public int next(int price) {
        // Write your code here.
        while (!stack.isEmpty() && stack.peek()[1] <= price) {
            stack.pop();
        }
        
        int prev = stack.isEmpty() ? -1 : stack.peek()[0];
        stack.push(new int[]{idx++, price});
        
        return idx - prev - 1;
    }
}