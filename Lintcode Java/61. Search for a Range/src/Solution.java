import java.util.Arrays;

public class Solution {
    /**
     * @param A:      an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return new int[]{-1, -1};
        }
        
        int[] res = {-1, -1};
        int l = 0, r = A.length - 1;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (A[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        
        if (A[l] != target) {
            return res;
        }
        
        res[0] = l;
        r = A.length - 1;
        
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (A[m] <= target) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        res[1] = l;
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}