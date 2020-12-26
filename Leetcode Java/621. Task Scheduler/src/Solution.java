import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        
        int[] count = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            count[tasks[i] - 'A']++;
        }
        
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((c1, c2) -> -Integer.compare(count[c1 - 'A'], count[c2 - 'A']));
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                maxHeap.add((char) ('A' + i));
            }
        }
        
        int res = 0;
        while (!maxHeap.isEmpty()) {
            List<Character> list = new ArrayList<>();
            int size = maxHeap.size();
            for (int i = 0; i < Math.min(size, n + 1); i++) {
                char top = maxHeap.poll();
                count[top - 'A']--;
                if (count[top - 'A'] > 0) {
                    list.add(top);
                }
                
                res++;
            }
            
            for (char ch : list) {
                maxHeap.offer(ch);
            }
            
            if (!maxHeap.isEmpty() && size < n + 1) {
                res += n + 1 - size;
            }
            
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        char[] t = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        // char[] t = {'A', 'A', 'A', 'B', 'B', 'B'};
        // System.out.println(t.length);
        System.out.println(new Solution().leastInterval(t, 2));
    }
}
