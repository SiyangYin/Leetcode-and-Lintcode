public class Solution {
    /**
     * @param N: an integer
     * @return: how many ways can we write it as a sum of consecutive positive integers
     */
    public int consecutiveNumbersSum(int N) {
        // Write your code here
        int ways = 1;
        for (int i = 2; i < Math.sqrt(2 * N); i++) {
            if (i % 2 == 0 && N % i == i / 2) {
                if (N / i - i / 2 + 1 > 0) {
                    ways++;
                }
            } else if (i % 2 != 0 && N % i == 0) {
                if (N / i - i / 2 > 0) {
                    ways++;
                }
            }
        }
        
        return ways;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().consecutiveNumbersSum(9));
    }
}
