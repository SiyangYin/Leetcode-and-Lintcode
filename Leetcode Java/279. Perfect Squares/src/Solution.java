import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        queue.offer(n);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int num = queue.poll();
    
                for (int j = 1; j * j <= num; j++) {
                    int a = num - j * j;
                    if (a == 0) {
                        return step;
                    }
                    
                    if (!visited[a]) {
                        queue.offer(a);
                        visited[a] = true;
                    }
                }
            }
        }
        
        return step;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(12));
    }
}
