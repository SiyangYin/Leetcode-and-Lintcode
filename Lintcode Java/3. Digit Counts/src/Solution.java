public class Solution {
    /**
     * @param k: An integer
     * @param n: An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        int count = 0;
        for (int i = 0; i <= n; i++) {
            count += countk(i, k);
        }
        return count;
    }
    
    public int countk(int number, int k) {
        int count = 0;
        if (number % 10 == k) {
            count++;
        }
        number /= 10;
        while (number != 0) {
            if (number % 10 == k) {
                count++;
            }
            number /= 10;
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().digitCounts(1, 1));
    }
    
}