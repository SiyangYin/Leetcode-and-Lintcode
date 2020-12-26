public class Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        
        int len1 = num1.length(), len2 = num2.length();
        int[] res = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                res[len1 + len2 - 2 - i - j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
    
        for (int i = 0; i < res.length - 1; i++) {
            res[i + 1] += res[i] / 10;
            res[i] %= 10;
        }
    
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            sb.append(res[i]);
        }
        
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }
        
        return new String(sb.reverse());
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().multiply("9", "9"));
    }
}
