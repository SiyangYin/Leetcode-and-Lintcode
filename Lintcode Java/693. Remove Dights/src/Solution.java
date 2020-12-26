public class Solution {
    /**
     * @param num: a number
     * @param k: the k digits
     * @return: the smallest number
     */
    public String removeKdigits(String num, int k) {
        // write your code here.
        if (k == num.length()) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c && k > 0) {
                sb.setLength(sb.length() - 1);
                k--;
            }
            
            sb.append(c);
        }
        
        if (k >= sb.length()) {
            return "0";
        }
        
        sb.setLength(sb.length() - k);
        
        int idx = 0;
        while (idx < sb.length() && sb.charAt(idx) == '0') {
            idx++;
        }
        
        return idx == sb.length() ? "0" : sb.substring(idx);
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().removeKdigits("1432219", 3));
        // System.out.println(new Solution().removeKdigits("10200", 1));
        // System.out.println(new Solution().removeKdigits("10", 3));
        // System.out.println(new Solution().removeKdigits("123456", 2));
        // System.out.println(new Solution().removeKdigits("637824", 3));
        // System.out.println(new Solution().removeKdigits("637824056", 8));
        // System.out.println(new Solution().removeKdigits("1571011", 6));
        System.out.println(new Solution().removeKdigits("1223", 1));
    }
}
