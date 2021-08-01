public class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }
    
    private boolean check(String a, String b) {
        int l = 0, r = a.length() - 1;
        while (l <= r && a.charAt(l) == b.charAt(r)) {
            l++;
            r--;
        }
        
        return isPalin(a, l, r) || isPalin(b, l, r);
    }
    
    private boolean isPalin(String s, int i, int j) {
        for (; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().checkPalindromeFormation("ceo", "oob"));
        System.out.println(new Solution().checkPalindromeFormation("x", "y"));
        System.out.println(new Solution().checkPalindromeFormation("abdef", "fecab"));
    }
}
