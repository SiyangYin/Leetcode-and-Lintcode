import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    /**
     * @param numbers: the numbers
     * @return: the minimum cost
     */
    public int mergeNumber(int[] numbers) {
        // Write your code here
        if (numbers == null || numbers.length <= 1) {
            return 0;
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int number : numbers) {
            minHeap.offer(number);
        }
        
        int res = 0;
        while (minHeap.size() > 1) {
            int a = minHeap.poll();
            int b = minHeap.poll();
            res += a + b;
            minHeap.offer(a + b);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().mergeNumber(new int[]{1, 2, 3, 4}));
        System.out.println(new Solution().mergeNumber(new int[]{2, 8, 4, 1}));
    }
}
