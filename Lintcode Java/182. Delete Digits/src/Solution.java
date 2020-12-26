public class Solution {
    /**
     * @param A: A positive integer which has N digits, A is a string
     * @param k: Remove k digits
     * @return: A string
     */
    public String DeleteDigits(String A, int k) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        int count = k;
        for (int i = 0; i < A.length(); i++) {
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > A.charAt(i) && count > 0) {
                sb.setLength(sb.length() - 1);
                count--;
            }
            sb.append(A.charAt(i));
        }
        
        sb.setLength(A.length() - k);
        
        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }
        
        if (sb.length() == 0) {
            return "0";
        }
        
        return sb.substring(i, sb.length());
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().DeleteDigits("1885", 1));
        // System.out.println(new Solution().DeleteDigits("1889", 1));
        System.out.println(new Solution().DeleteDigits("178542", 4));
        System.out.println(new Solution().DeleteDigits("90249", 2));
    }
}
