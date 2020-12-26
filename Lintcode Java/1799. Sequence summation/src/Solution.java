public class Solution {
    /**
     * @param i:
     * @param j:
     * @param k:
     * @return: nothing
     */
    public long equlSum(long i, long j, long k) {
        // Write your code here
        long res = 0;
        
        res += (i + j) * (j - i + 1) / 2;
        res += (j - 1 + k) * (j - k) / 2;
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().equlSum(5, 9, 6));
    }
}
