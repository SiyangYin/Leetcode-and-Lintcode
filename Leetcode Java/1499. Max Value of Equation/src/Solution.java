import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            while (!deque.isEmpty() && points[deque.peekFirst()][0] < points[i][0] - k) {
                deque.pollFirst();
            }
            
            if (!deque.isEmpty()) {
                res = Math.max(res, points[i][0] + points[i][1] + points[deque.peekFirst()][1] - points[deque.peekFirst()][0]);
            }
            
            while (!deque.isEmpty() && points[i][1] - points[i][0] >= points[deque.peekLast()][1] - points[deque.peekLast()][0]) {
                deque.pollLast();
            }
            
            deque.offerLast(i);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] p = {{1, 3}, {2, 0}, {5, 10}, {6, -10}};
        System.out.println(new Solution().findMaxValueOfEquation(p, 1));
    }
}
