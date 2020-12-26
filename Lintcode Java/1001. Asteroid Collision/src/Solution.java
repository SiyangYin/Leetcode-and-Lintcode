import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    /**
     * @param asteroids: a list of integers
     * @return: return a list of integers
     */
    public int[] asteroidCollision(int[] asteroids) {
        // write your code here
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty() || asteroids[i] > 0) {
                stack.push(asteroids[i]);
                continue;
            }
            
            while (true) {
                if (stack.isEmpty()) {
                    stack.push(asteroids[i]);
                    break;
                }
                
                if (stack.peek() < 0) {
                    stack.push(asteroids[i]);
                    break;
                } else if (stack.peek() == -asteroids[i]) {
                    stack.pop();
                    break;
                } else if (stack.peek() < -asteroids[i]) {
                    stack.pop();
                } else {
                    break;
                }
            }
        }
        
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pollLast();
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().asteroidCollision(new int[]{5, 10, -5})));
        System.out.println(Arrays.toString(new Solution().asteroidCollision(new int[]{10, 2, -5})));
    }
}
