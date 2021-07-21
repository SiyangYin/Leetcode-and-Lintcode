public class Solution {
    public int balancedString(String s) {
        int[] tot = new int[256];
        for (int i = 0; i < s.length(); i++) {
            tot[s.charAt(i)]++;
        }
        
        char[] chs = {'Q', 'W', 'E', 'R'};
        if (check(tot, s.length() / 4, chs)) {
            return 0;
        }
        
        int res = s.length();
        for (int i = 0, j = 0; i < s.length(); i++) {
            tot[s.charAt(i)]--;
            while (j <= i && check(tot, s.length() / 4, chs)) {
                res = Math.min(res, i - j + 1);
                tot[s.charAt(j)]++;
                j++;
            }
        }
        
        return res;
    }
    
    private boolean check(int[] tot, int k, char[] chs) {
        for (char ch : chs) {
            if (tot[ch] > k) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().balancedString("QWER"));
        System.out.println(new Solution().balancedString("QQWE"));
        System.out.println(new Solution().balancedString("QQQW"));
    }
}
