public class Solution {
    /**
     * @param x: the wall's height
     * @return: YES or NO
     */
    public String isBuild(int x) {
        // write you code here
        for (int i = 0; i * 7 <= x; i++) {
            if ((x - i * 7) % 3 == 0) {
                return "YES";
            }
        }
        
        return "NO";
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isBuild(10));
    }
}
