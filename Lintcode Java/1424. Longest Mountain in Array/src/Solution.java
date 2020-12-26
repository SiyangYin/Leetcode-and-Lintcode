public class Solution {
    /**
     * @param A:
     * @return: the length of the longest mountain
     */
    public int longestMountain(int[] A) {
        // write your code here
        int res = 0;
        int[] updp = new int[A.length], downdp = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            updp[i] = 1;
            if (i > 0 && A[i - 1] < A[i]) {
                updp[i] += updp[i - 1];
            }
        }
        for (int i = A.length - 1; i >= 0; i--) {
            downdp[i] = 1;
            if (i < A.length - 1 && A[i + 1] < A[i]) {
                downdp[i] += downdp[i + 1];
            }
        }
    
        for (int i = 0; i < A.length; i++) {
            if (updp[i] > 1 && downdp[i] > 1) {
                res = Math.max(res, updp[i] + downdp[i] - 1);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}));
    }
}
