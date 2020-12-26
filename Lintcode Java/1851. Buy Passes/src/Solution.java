import java.util.*;

public class Solution {
    /**
     * @param arr: the line
     * @param k: Alex place
     * @return: the time when Alex requires to buy all passes
     */
    public int buyPasses(int[] arr, int k) {
        // Write your code here.
        if (arr == null || arr.length == 0) {
            return 0;
        }
    
        Queue<Integer> queue = new ArrayDeque<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            queue.offer(i);
        }
        
        int count = 0;
        while (arr[k] != 0) {
            int head = queue.poll();
            if (arr[head] > 0) {
                arr[head] -= 1;
                if (arr[head] > 0) {
                    queue.offer(head);
                }
            }
            count++;
            
            if (arr[k] == 0) {
                break;
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().buyPasses(new int[]{1, 2, 5}, 1));
        System.out.println(new Solution().buyPasses(new int[]{3, 2, 1}, 0));
    }
}
