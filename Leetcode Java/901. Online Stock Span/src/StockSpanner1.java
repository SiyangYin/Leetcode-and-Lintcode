import java.util.*;

public class StockSpanner1 {
    private List<Integer> list;
    private Deque<Integer> stack;
    public StockSpanner1() {
        list = new ArrayList<>();
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        list.add(price);
        if (stack.isEmpty() || price < list.get(stack.peek())) {
            stack.push(list.size() - 1);
            return 1;
        }
        else {
            while (!stack.isEmpty() && list.get(stack.peek()) <= price) {
                stack.pop();
            }
            int i = !stack.isEmpty() ? stack.peek() : -1;
            stack.push(list.size() - 1);
            return list.size() - 1 - i;
        }
    }
}
