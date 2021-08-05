import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<int[]> deque = new LinkedList<>();
        int res = Integer.MIN_VALUE;
        for (int[] point : points) {
            while (!deque.isEmpty() && deque.peekFirst()[0] < point[0] - k) {
                deque.pollFirst();
            }
            
            if (!deque.isEmpty()) {
                res = Math.max(res, point[0] + point[1] + deque.peekFirst()[1] - deque.peekFirst()[0]);
            }
            
            while (!deque.isEmpty() && point[1] - point[0] >= deque.peekLast()[1] - deque.peekLast()[0]) {
                deque.pollLast();
            }
            
            deque.offerLast(point);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] p = {{1, 3}, {2, 0}, {5, 10}, {6, -10}};
        System.out.println(new Solution().findMaxValueOfEquation(p, 1));
    }
}
