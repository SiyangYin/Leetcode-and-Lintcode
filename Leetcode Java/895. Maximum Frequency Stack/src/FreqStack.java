import java.util.*;

public class FreqStack {
    
    private Map<Integer, Integer> freq;
    private List<Deque<Integer>> list;
    
    public FreqStack() {
        freq = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public void push(int x) {
        freq.put(x, freq.getOrDefault(x, 0) + 1);
        if (list.size() < freq.get(x)) {
            list.add(new ArrayDeque<>());
        }
        
        list.get(freq.get(x) - 1).push(x);
    }
    
    public int pop() {
        if (!list.isEmpty() && list.get(list.size() - 1).isEmpty()) {
            list.remove(list.size() - 1);
        }
        
        int res = list.get(list.size() - 1).pop();
        freq.put(res, freq.get(res) - 1);
        return res;
    }
}
