public class Solution {
    /**
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return product of num1 and num2
     */
    public String multiply(String num1, String num2) {
        // write your code here
        int n1 = num1.length(), n2 = num2.length();
        int[] digs = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                digs[n1 + n2 - 2 - (i + j)] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digs.length; i++) {
            if (i + 1 < digs.length) {
                digs[i + 1] += digs[i] / 10;
            }
            sb.append(digs[i] % 10);
        }
        
        if (digs[digs.length - 1] > 10) {
            sb.append(digs[digs.length - 1] / 10);
        }
        
        int i = sb.length() - 1;
        while (i > 0 && sb.charAt(i) == '0') {
            i--;
        }
        
        return sb.reverse().substring(sb.length() - (i + 1));
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().multiply("123", "45"));
    }
}
