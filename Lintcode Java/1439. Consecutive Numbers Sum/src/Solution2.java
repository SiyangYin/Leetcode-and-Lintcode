public class Solution2 {
    /**
     * @param N: an integer
     * @return: how many ways can we write it as a sum of consecutive positive integers
     */
    public int consecutiveNumbersSum(int N) {
        // Write your code here
        int res = 0, count = 1;
        double a = 1, num = (double) N;
        while (a >= 1) {
            a = num / count - (count - 1) / 2.0;
            if (isInteger(a) && a >= 1) {
                res++;
            }
            count++;
        }
        
        return res;
    }
    
    private boolean isInteger(double a) {
        return Math.abs(a - (int) a) <= 1E-10;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().consecutiveNumbersSum(5));
        System.out.println(new Solution2().consecutiveNumbersSum(9));
    }
}
