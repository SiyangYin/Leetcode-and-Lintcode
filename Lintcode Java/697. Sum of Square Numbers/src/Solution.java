public class Solution {
    /**
     * @param num: the given number
     * @return: whether whether there're two integers
     */
    public boolean checkSumOfSquareNumbers(int num) {
        // write your code here
        if (num < 0) {
            return false;
        }
        
        for (int i = 0; i < (int) Math.sqrt(num) + 1; i++) {
            int rem = (int) Math.sqrt(num - i * i);
            if (rem * rem + i * i == num) {
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().checkSumOfSquareNumbers(5));
        System.out.println(new Solution().checkSumOfSquareNumbers(0));
        System.out.println(new Solution().checkSumOfSquareNumbers(10));
    }
}
