public class Solution {
    /**
     * @param A: A string array
     * @return: Minimum D.length
     */
    public int minDeletionSize(String[] A) {
        // write your code here
        int res = 0;
        if (A.length == 1) {
            return res;
        }
        
        for (int i = 0; i < A[0].length(); i++) {
            for (int j = 1; j < A.length; j++) {
                if (A[j].charAt(i) < A[j - 1].charAt(i)) {
                    res++;
                    break;
                }
            }
        }
        
        return res;
    }
}
