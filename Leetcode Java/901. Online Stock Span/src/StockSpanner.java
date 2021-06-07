import java.util.Deque;
import java.util.LinkedList;

public class StockSpanner {
    
    private Deque<int[]> stk;
    private int idx;
    
    public StockSpanner() {
        stk = new LinkedList<>();
    }
    
    public int next(int price) {
        idx++;
        while (!stk.isEmpty() && stk.peek()[1] <= price) {
            stk.pop();
        }
        
        int res = idx - (stk.isEmpty() ? 0 : stk.peek()[0]);
        stk.push(new int[]{idx, price});
        return res;
    }
}
