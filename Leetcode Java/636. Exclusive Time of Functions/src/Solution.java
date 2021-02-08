import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        int last = 0;
        for (String log : logs) {
            String[] split = log.split(":");
            int id = Integer.parseInt(split[0]), time = Integer.parseInt(split[2]);
            String op = split[1];
            if ("start".equals(op)) {
                if (!stack.isEmpty()) {
                    res[stack.peek()] += time - last;
                }
                
                stack.push(id);
                last = time;
            } else {
                res[stack.pop()] += time - last + 1;
                last = time + 1;
            }
            
        }
        
        return res;
    }
}
