import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * @param A: An integer array
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> continuousSubarraySum(int[] A) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        
        if (A == null || A.length == 0) {
            return res;
        }
        res.add(0);
        res.add(0);
        
        int start = 0, end = 0;
        int sum = A[0], maxSum = A[0];
        for (int i = 1; i < A.length; i++) {
            if (sum >= 0) {
                sum += A[i];
                end = i;
            } else {
                sum = A[i];
                start = end = i;
            }
            
            if (sum > maxSum) {
                maxSum = sum;
                res.set(0, start);
                res.set(1, end);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().continuousSubarraySum(new int[]{-3, 1, 3, -3, 4}));
        // System.out.println(new Solution().continuousSubarraySum(new int[]{0, 1, 0, 1}));
        // System.out.println(new Solution().continuousSubarraySum(new int[]{-100, -10, -5, -10, -5}));
        int[] A = {1, 1, 1, 1, 1, 1, 1, 1, 1, -19, 1, 1, 1, 1, 1, 1, 1, -2, 1, 1, 1, 1, 1, 1, 1, 1, -2, 1, -15, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        // System.out.println(A.length);
        int sum = 0;
        for (int i = 29; i <= 46; i++) {
            sum += A[i];
        }
        System.out.println(sum);
    
        System.out.println(new Solution().continuousSubarraySum(A));
    }
}
