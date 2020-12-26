public class Solution {
    /**
     * @param num: a string
     * @param k: an integer
     * @return: return a string
     */
    public String removeKdigits(String num, int k) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > num.charAt(i) && k > 0) {
                sb.setLength(sb.length() - 1);
                k--;
            }
            
            sb.append(num.charAt(i));
        }
        
        if (k >= sb.length()) {
            return "0";
        }
        
        sb.setLength(sb.length() - k);
        int i = 0;
        while (i + 1 < sb.length() && sb.charAt(i) == '0') {
            i++;
        }
        
        return sb.substring(i);
    }
}
