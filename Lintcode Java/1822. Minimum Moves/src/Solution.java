public class Solution {
    /**
     * @param s: a string
     * @return: return the minimum number of moves
     */
    public int MinimumMoves(String s) {
        // write your code here
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            
            res += (j - i) / 3;
            i = j - 1;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().MinimumMoves("baaabbaabbba"));
    }
}
