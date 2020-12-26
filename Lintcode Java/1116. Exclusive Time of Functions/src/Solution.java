import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    /**
     * @param n: a integer
     * @param logs: a list of integers
     * @return: return a list of integers
     */
    public int[] exclusiveTime(int n, List<String> logs) {
        // write your code here
        int[] time = new int[n];
        if (logs == null || logs.size() == 0) {
            return time;
        }
    
        Stack<String[]> stack = new Stack<>();
        int lastTimeStamp = 0;
        for (String s : logs) {
            String[] log = s.split(":");
            if (stack.isEmpty()) {
                stack.push(log);
                lastTimeStamp = Integer.parseInt(log[2]);
            } else {
                String[] lastLog = stack.peek();
                time[Integer.parseInt(lastLog[0])] += Integer.parseInt(log[2]) -
                        lastTimeStamp;
                lastTimeStamp = Integer.parseInt(log[2]);
                if (lastLog[0].equals(log[0]) && "start".equals(lastLog[1]) &&
                "end".equals(log[1])) {
                    time[Integer.parseInt(log[0])]++;
                    lastTimeStamp++;
                    stack.pop();
                } else {
                    stack.push(log);
                }
            }
        }
        return time;
    }
    
    public static void main(String[] args) {
        List<String> logs = Arrays.asList("8:start:27","9:start:31","8:start:38",
                "8:end:43","9:start:44","9:end:49","9:end:52","8:end:54");
        System.out.println(Arrays.toString(new Solution().exclusiveTime(10, logs)));
    }
}