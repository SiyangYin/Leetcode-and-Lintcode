public class Solution {
    /**
     * @param a: the array a
     * @param q: the queries q
     * @return: for each query, return the number of legal integers
     */
    public int[] getAns(int[] a, int[][] q) {
        // write your code here
        int max = 0;
        for (int n : a) {
            max = Math.max(max, n);
        }
        
        int[] count = new int[max + 1];
        for (int n : a) {
            count[n]++;
        }
        
        int[] preSum = new int[count.length + 1];
        for (int i = 0; i < count.length; i++) {
            preSum[i + 1] = preSum[i] + count[i];
        }
        
        int[] res = new int[q.length];
        for (int i = 0; i < q.length; i++) {
            int l = q[i][0], r = q[i][1];
            if (l > max) {
                res[i] = 0;
                continue;
            } else {
                r = Math.min(max, r);
            }
            
            res[i] = preSum[r + 1] - preSum[l];
        }
        
        return res;
    }
}
