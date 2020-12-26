public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        int[] count = new int[256];
        
        int res = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            count[s.charAt(j)]++;
            while (i <= j && !check(count, k)) {
                count[s.charAt(i)]--;
                i++;
            }
            
            if (check(count, k)) {
                res = Math.max(res, j - i + 1);
            }
        }
        
        return res;
    }
    
    private boolean check(int[] count, int k) {
        int c = 0;
        for (int i = 0; i < 256; i++) {
            if (count[i] > 0) {
                c++;
            }
        }
        
        return c <= k;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstringKDistinct("abc", 2));
        System.out.println(new Solution().lengthOfLongestSubstringKDistinct("eceba", 3));
        System.out.println(new Solution().lengthOfLongestSubstringKDistinct("WORLD", 3));
        System.out.println(new Solution().lengthOfLongestSubstringKDistinct("W", 1));
    }
}
