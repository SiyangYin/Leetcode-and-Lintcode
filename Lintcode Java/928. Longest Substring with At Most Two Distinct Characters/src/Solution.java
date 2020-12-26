public class Solution {
    /**
     * @param s: a string
     * @return: the length of the longest substring T that contains at most 2 distinct characters
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // Write your code here
        int[] count = new int[256];
        int res = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            count[s.charAt(j)]++;
            while (i <= j && !check(count)) {
                count[s.charAt(i)]--;
                i++;
            }
            
            if (check(count)) {
                res = Math.max(res, j - i + 1);
            }
        }
        
        return res;
    }
    
    private boolean check(int[] count) {
        int c = 0;
        for (int i = 0; i < 256; i++) {
            if (count[i] > 0) {
                c++;
            }
        }
        
        return c <= 2;
    }
}
