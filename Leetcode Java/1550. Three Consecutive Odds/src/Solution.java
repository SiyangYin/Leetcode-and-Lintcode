public class Solution {
    public boolean threeConsecutiveOdds(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                continue;
            }
            
            if (i + 1 >= A.length || A[i + 1] % 2 == 0) {
                i++;
                continue;
            }
            
            if (i + 2 >= A.length || A[i + 2] % 2 == 0) {
                i += 2;
                continue;
            }
            
            return true;
        }
        
        return false;
    }
}
