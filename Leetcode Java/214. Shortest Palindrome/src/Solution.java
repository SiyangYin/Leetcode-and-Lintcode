public class Solution {
    public String shortestPalindrome(String s) {
        int[] ne = getNext(s + "#" + new StringBuilder(s).reverse() + "$");
        return new StringBuilder(s.substring(ne[s.length() * 2 + 1])).reverse() + s;
    }
    
    private int[] getNext(String p) {
        int[] ne = new int[p.length()];
        for (int i = 0, j = ne[0] = -1; i < p.length() - 1; ) {
            if (j == -1 || p.charAt(i) == p.charAt(j)) {
                ne[++i] = ++j;
            } else {
                j = ne[j];
            }
        }
        
        return ne;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().shortestPalindrome("abab"));
        System.out.println(new Solution().shortestPalindrome("abcd"));
    }
}
