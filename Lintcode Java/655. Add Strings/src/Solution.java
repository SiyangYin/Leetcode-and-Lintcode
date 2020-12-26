public class Solution {
    /**
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return sum of num1 and num2
     */
    public String addStrings(String num1, String num2) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        int id1 = num1.length() - 1, id2 = num2.length() - 1;
        int cur = 0;
        while (id1 >= 0 || id2 >= 0) {
            if (id1 >= 0) {
                cur += num1.charAt(id1--) - '0';
            }
            if (id2 >= 0) {
                cur += num2.charAt(id2--) - '0';
            }
            sb.append(cur % 10);
            cur /= 10;
        }
        if (cur == 1) {
            sb.append(1);
        }
        
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().addStrings("123", "45"));
    }
}
