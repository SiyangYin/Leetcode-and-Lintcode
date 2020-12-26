import java.util.Arrays;

public class Solution {
    /**
     * @param digits: a number represented as an array of digits
     * @return: the result
     */
    public int[] plusOne(int[] digits) {
        // write your code here
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] %= 10;
        }
        
        if (carry == 0) {
            return digits;
        }
        
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        for (int i = 0; i < digits.length; i++) {
            res[i + 1] = digits[i];
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{9})));
    }
}
