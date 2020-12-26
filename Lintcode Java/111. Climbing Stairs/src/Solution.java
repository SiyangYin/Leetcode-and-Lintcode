public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if (n == 0) {
            return 0;
        }
        
        int n1 = 1, n2 = 2;
        for (int i = 0; i < n - 2; i++) {
            n2 += n1;
            n1 = n2 - n1;
        }
        
        return n == 1 ? n1 : n2;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(3));
    }
}
