public class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        
        if (sum % 3 != 0) {
            return false;
        }
    
        int curSum = 0, count = 0;
        for (int i = 0; i < A.length; i++) {
            curSum += A[i];
            if (curSum == sum / 3) {
                count++;
                curSum = 0;
            }
        }
        
        return count == 3 || (sum == 0 && count >= 3);
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1}));
        // System.out.println(new Solution().canThreePartsEqualSum(new int[]{0,2,1,-6,6,7,9,-1,2,0,1}));
        System.out.println(new Solution().canThreePartsEqualSum(new int[]{1, 1, 0, 1, 1, 1, 1}));
    }
}
