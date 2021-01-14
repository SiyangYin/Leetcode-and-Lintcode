public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            int j = i + 1;
            while (j < A.length && A[i + 1] - A[i] == A[j] - A[j - 1]) {
                j++;
            }
            
            int len = j - i;
            if (len >= 3) {
                res += (1 + len - 3 + 1) * (len - 3 + 1) / 2;
                i = j - 1;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
        // System.out.println(new Solution().numberOfArithmeticSlices(new int[]{1}));
        System.out.println(new Solution().numberOfArithmeticSlices(new int[]{1, 2, 3, 8, 9, 10}));
    }
}
