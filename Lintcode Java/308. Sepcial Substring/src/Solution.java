public class Solution {
    /**
     * @param str: a string for calculating.
     * @param k: the length of special substring.
     * @return: return the number of special substrings.
     */
    public int specialSubstringCount(String str, int k) {
        // write your code here.
        int[] count = new int[26];
        for (int i = 0; i < k; i++) {
            count[str.charAt(i) - 'a']++;
        }
        
        int res = 0;
        if (check(count)) {
            res++;
        }
    
        for (int i = k; i < str.length(); i++) {
            count[str.charAt(i - k) - 'a']--;
            count[str.charAt(i) - 'a']++;
            if (check(count)) {
                res++;
            }
        }
        
        return res;
    }
    
    private boolean check(int[] count) {
        int num = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] >= 2) {
                num++;
            }
        }
        
        return num == 1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().specialSubstringCount("helloo", 4));
    }
}
