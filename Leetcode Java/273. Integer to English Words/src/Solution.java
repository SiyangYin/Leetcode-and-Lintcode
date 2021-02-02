public class Solution {
    
    private String[] n0_19 = {
            "Zero", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    private String[] n20_90 = {
            "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
            "Seventy", "Eighty", "Ninety"};
    
    private String[] n1000 = {" Billion ", " Million ", " Thousand ", ""};
    
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = (int) 1e9, j = 0; i >= 1; i /= 1000, j++) {
            if (num >= i) {
                sb.append(get(num / i)).append(n1000[j]);
                num %= i;
            }
        }
        
        if (sb.charAt(sb.length() - 1) == ' ') {
            sb.setLength(sb.length() - 1);
        }
        
        return sb.toString();
    }
    
    // 得到1~999的英文表示
    private String get(int x) {
        StringBuilder sb = new StringBuilder();
        if (x >= 100) {
            sb.append(n0_19[x / 100]).append(" Hundred ");
            x %= 100;
        }
        if (x >= 20) {
            sb.append(n20_90[x / 10 - 2]).append(' ');
            x %= 10;
            if (x != 0) {
                sb.append(n0_19[x]);
            }
        } else if (x > 0) {
            sb.append(n0_19[x]);
        }
        
        if (sb.charAt(sb.length() - 1) == ' ') {
            sb.setLength(sb.length() - 1);
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().numberToWords(123));
        // System.out.println(new Solution().numberToWords(12345));
        System.out.println(new Solution().numberToWords(10000));
    }
}
