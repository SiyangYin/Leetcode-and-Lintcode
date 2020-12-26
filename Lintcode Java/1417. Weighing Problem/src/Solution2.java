public class Solution2 {
    /**
     * @param n: The number of coins
     * @return: The Minimum weighing times int worst case
     */
    public int minimumtimes(int n) {
        // Write your code here
        int res = 0, prod = 1;
        while (prod < n) {
            prod *= 3;
            res++;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().minimumtimes(10));
        System.out.println(new Solution2().minimumtimes(3));
    }
}
