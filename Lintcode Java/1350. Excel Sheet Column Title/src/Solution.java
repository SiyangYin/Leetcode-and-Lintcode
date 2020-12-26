public class Solution {
    /**
     * @param n: a integer
     * @return: return a string
     */
    public String convertToTitle(int n) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append((char) ((n - 1) % 26 + 'A'));
            n = (n - 1) / 26;
        }
        
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().convertToTitle(26));
        System.out.println(new Solution().convertToTitle(27));
    }
}
