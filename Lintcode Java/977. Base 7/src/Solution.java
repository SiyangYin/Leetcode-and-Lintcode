public class Solution {
    /**
     * @param num: the given number
     * @return: The base 7 string representation
     */
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        int sign = num < 0 ? -1 : 1;
        num = Math.abs(num);
        
        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }
        
        if (sign == -1) {
            sb.append('-');
        }
        
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().convertToBase7(-7));
    }
}
