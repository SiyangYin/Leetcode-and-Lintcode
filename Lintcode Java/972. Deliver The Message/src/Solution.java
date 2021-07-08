import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    /**
     * @param t:           the time of each employee to pass a meeage
     * @param subordinate: the subordinate of each employee
     * @return: the time of the last staff recieve the message
     */
    public int deliverMessage(int[] t, int[][] subordinate) {
        // Write your code here
        int[] dist = new int[t.length];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (subordinate[cur][0] != -1) {
                for (int next : subordinate[cur]) {
                    queue.offer(next);
                    dist[next] = dist[cur] + t[cur];
                }
            }
        }
        
        int res = 0;
        for (int x : dist) {
            res = Math.max(res, x);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] t = {1, 2, 1, 4, 5};
        int[][] l = {{1, 2}, {3, 4}, {-1}, {-1}, {-1}};
        System.out.println(new Solution().deliverMessage(t, l));
    }
}
