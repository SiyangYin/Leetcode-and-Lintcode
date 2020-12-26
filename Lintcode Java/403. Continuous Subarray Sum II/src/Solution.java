import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * @param A: An integer array
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> continuousSubarraySumII(int[] A) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        int sum = 0;
        int start = 0, end = 0;
        
        int maxSum = Integer.MIN_VALUE, s = 0, e = 0;
        int totalSum = 0;
        for (int i = 0; i < A.length; i++) {
            totalSum += A[i];
            if (sum + A[i] > A[i]) {
                end = i;
                sum += A[i];
            } else {
                start = end = i;
                sum = A[i];
            }
            
            if (sum > maxSum) {
                maxSum = sum;
                s = start;
                e = end;
            }
        }
        
        int minSum = totalSum;
        sum = start = end = 0;
        for (int i = 0; i < A.length; i++) {
            if (sum + A[i] < A[i]) {
                end = i;
                sum += A[i];
            } else {
                start = end = i;
                sum = A[i];
            }
            
            if (sum < minSum) {
                minSum = sum;
                if (totalSum - minSum > maxSum) {
                    s = end + 1;
                    e = start - 1;
                }
            }
        }
        
        res.add(s % A.length);
        res.add(e % A.length);
        return res;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().continuousSubarraySumII(new int[]{3, 1, -100, -3, 4}));
        System.out.println(new Solution().continuousSubarraySumII(new int[]{-1, 0, 3, 3, 5}));
    }
}
