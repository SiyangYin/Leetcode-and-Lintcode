public class Solution {
    /**
     * @param n:
     * @param k:
     * @param len:
     * @param num: //same as problem
     * @return: //return long
     */
    public long solve(int n, int k, int len, int[] num) {
        // write your code here
        long res = 0, sum = 0;
        
        for (int i = 0; i < len; i++) {
            sum += num[i];
        }
        
        if ((double) sum / len > k) {
            res++;
        }
        
        for (int i = len; i < n; i++) {
            sum += num[i] - num[i - len];
            
            if ((double) sum / len > k) {
                res++;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().solve(8, 4, 3, new int[]{2, 2, 2, 2, 5, 5, 5, 8}));
    }
}
