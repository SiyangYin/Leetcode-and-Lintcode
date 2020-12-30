import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                    continue;
                }
                
                boolean exploded = false;
                while (!stack.isEmpty() && stack.peek() > 0) {
                    if (stack.peek() > -asteroid) {
                        exploded = true;
                        break;
                    } else if (stack.peek() == -asteroid) {
                        exploded = true;
                        stack.pop();
                        break;
                    } else if (stack.peek() < -asteroid) {
                        stack.pop();
                    }
                }
                
                if (!exploded) {
                    stack.push(asteroid);
                }
            }
        }
        
        int[] res = new int[stack.size()];
        int idx = 0;
        while (!stack.isEmpty()) {
            res[idx++] = stack.pop();
        }
        
        reverse(res);
        return res;
    }
    
    private void reverse(int[] A) {
        for (int i = 0, j = A.length - 1; i < j; i++, j--) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }
}
