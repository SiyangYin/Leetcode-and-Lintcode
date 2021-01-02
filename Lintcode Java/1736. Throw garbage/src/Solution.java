import java.util.Arrays;

public class Solution {
    /**
     * @param A: the weight of all garbage bags.
     * @return: an integer represent the minimum number of times.
     */
    public int Count_ThrowTimes(float[] A) {
        // Write your code here.
        Arrays.sort(A);
        
        int res = 0, l = 0, r = A.length - 1;
        float sum = 0;
        while (l < r) {
            sum = A[l] + A[r];
            if (sum > 3) {
                r--;
                res++;
            } else {
                r--;
                l++;
                
                res++;
            }
        }
        
        return res + (l == r ? 1 : 0);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().Count_ThrowTimes(new float[]{1.01f, 2.21f, 1.3f}));
    }
}
