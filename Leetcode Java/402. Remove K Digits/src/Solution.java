public class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > num.charAt(i) && k > 0) {
                sb.setLength(sb.length() - 1);
                k--;
            }
        
            sb.append(num.charAt(i));
        }
    
        if (k < sb.length()) {
            sb.setLength(sb.length() - k);
        } else {
            return "0";
        }
    
        int i = 0;
        while (i < sb.length() - 1 && sb.charAt(i) == '0') {
            i++;
        }
    
        return sb.substring(i);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().removeKdigits("10200", 1));
        System.out.println(new Solution().removeKdigits("1432219", 3));
    }
}
