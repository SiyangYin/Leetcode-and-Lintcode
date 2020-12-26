public class Solution {
    /**
     * @param A: An array of integers
     * @return: A long integer
     */
    public long permutationIndex(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        long res = 0, fact = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            int count = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[i]) {
                    count++;
                }
            }
            
            res += count * fact;
            fact *= A.length - i;
        }
        
        return res + 1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().permutationIndex(new int[]{3, 2, 1}));
    }
}
