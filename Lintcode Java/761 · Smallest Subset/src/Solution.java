import java.util.Arrays;

public class Solution {
    /**
     * @param A:  an array of non-negative integers
     * @return: minimum number of elements
     */
    public int minElements(int[] A) {
        // write your code here
        Arrays.sort(A);
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
    
        for (int i = A.length - 1, cur = 0; i >= 0; i--) {
            cur += A[i];
            if (cur > sum - cur) {
                return A.length - i;
            }
        }
        
        return 0;
    }
}
