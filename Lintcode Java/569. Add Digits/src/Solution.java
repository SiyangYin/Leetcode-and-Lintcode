public class Solution {
    /**
     * @param num: a non-negative integer
     * @return: one digit
     */
    public int addDigits(int num) {
        // write your code here
        return (num - 1) % 9 + 1;
    }
    
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
        
        System.out.println(new Solution().addDigits(i));
        }
    }
}
