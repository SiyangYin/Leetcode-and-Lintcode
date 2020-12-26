public class Solution {
    public String reformatNumber(String number) {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            if (Character.isDigit(number.charAt(i))) {
                tmp.append(number.charAt(i));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tmp.length(); i++) {
            sb.append(tmp.charAt(i));
            if (i % 3 == 2) {
                sb.append('-');
            }
        }
        
        if (sb.length() >= 1 && sb.charAt(sb.length() - 1) == '-') {
            sb.setLength(sb.length() - 1);
        } else if (sb.length() >= 2 && sb.charAt(sb.length() - 2) == '-') {
            sb.setCharAt(sb.length() - 2, sb.charAt(sb.length() - 3));
            sb.setCharAt(sb.length() - 3, '-');
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().reformatNumber("123"));
        // System.out.println(new Solution().reformatNumber("1234"));
        System.out.println(new Solution().reformatNumber("1-23-45 6"));
    }
}
