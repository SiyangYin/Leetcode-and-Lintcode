import java.util.Arrays;

public class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int[] res = new int[A.length];
        for (int i = 0, j = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                res[j] = A[i];
                j += 2;
            }
        }
    
        for (int i = 0, j = 1; i < A.length; i++) {
            if (A[i] % 2 != 0) {
                res[j] = A[i];
                j += 2;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortArrayByParityII(new int[]{4, 2, 5, 7})));
    }
}
