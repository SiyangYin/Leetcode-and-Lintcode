public class Solution {
    
    public String convertToTitle(int n) {
        if (1 <= n && n <= 26) {
            return String.valueOf((char) ('A' + (n - 1)));
        }
        
        return convertToTitle((n - 1) / 26) + (char) ('A' + (n - 1) % 26);
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().convertToTitle(26));
        System.out.println(new Solution().convertToTitle(27));
        System.out.println(new Solution().convertToTitle(25));
        System.out.println(new Solution().convertToTitle(28));
        System.out.println(new Solution().convertToTitle(26));
        System.out.println(new Solution().convertToTitle(701));
    }
}
