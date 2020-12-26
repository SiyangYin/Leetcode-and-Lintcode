public class Solution {
    /**
     * @param a:
     * @param b:
     * @param c:
     * @param d:
     * @return: return "Yes" or "No"
     */
    public String IsPossible(int a, int b, int c, int d) {
        // write your code here
        while (c >= a || d >= b) {
            if (c == a && d == b) {
                return "Yes";
            }
            
            if (c >= d) {
                c -= d;
            } else {
                d -= c;
            }
        }
        
        return "No";
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().IsPossible(1, 4, 45, 28));
    }
}
