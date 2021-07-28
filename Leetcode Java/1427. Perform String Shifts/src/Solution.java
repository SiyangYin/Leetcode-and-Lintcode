public class Solution {
    public String stringShift(String s, int[][] shift) {
        int x = 0;
        for (int[] sh : shift) {
            x += (sh[0] * 2 - 1) * sh[1];
        }
        
        x = (x % s.length() + s.length()) % s.length();
        return s.substring(s.length() - x) + s.substring(0, s.length() - x);
    }
    
    public static void main(String[] args) {
        int[][] sh = {{0, 1}, {1, 2}};
        System.out.println(new Solution().stringShift("abc", sh));
    }
}
