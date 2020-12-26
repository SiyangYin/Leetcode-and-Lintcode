import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param n: The number of digits
     * @return: All narcissistic numbers with n digits
     */
    public List<Integer> getNarcissisticNumbers(int n) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        
        for (int i = getRange(n)[0]; i <= getRange(n)[1]; i++) {
            List<Integer> digits = getDigit(i);
            int sum = 0;
            
            for (int dig : digits) {
                sum += (int) Math.pow(dig, n);
            }
            
            if (sum == i) {
                res.add(i);
            }
        }
        
        return res;
    }
    
    public int[] getRange(int n) {
        if (n == 1) {
            return new int[]{0, 9};
        }
        
        int j = (int) Math.pow(10, n - 1);
        return new int[]{j, j * 10 - 1};
    }
    
    public List<Integer> getDigit(int n) {
        List<Integer> list = new ArrayList<>();
        
        if (n == 0) {
            list.add(0);
            return list;
        }
        
        while (n != 0) {
            list.add(n % 10);
            n /= 10;
        }
        
        return list;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().getNarcissisticNumbers(3));
        System.out.println(new Solution().getNarcissisticNumbers(4));
    }
}