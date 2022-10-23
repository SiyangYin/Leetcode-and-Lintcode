import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class StockSpanner2 {
    private List<Integer> list;
    private Deque<Integer> stack;
    public StockSpanner2() {
        list = new ArrayList<>();
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        list.add(price);
        while (!stack.isEmpty() && list.get(stack.peek()) <= price) {
            stack.pop();
        }
        int i = !stack.isEmpty() ? stack.peek() : -1;
        stack.push(list.size() - 1);
        return list.size() - 1 - i;
    }
}
