public class Solution {
    /**
     * @param s: a string
     * @param k: a integer
     * @return: return a integer
     */
    public int characterReplacement(String s, int k) {
        // write your code here
        int[] count = new int[26];
        
        int res = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'A']++;
            while (!check(count, k)) {
                count[s.charAt(j) - 'A']--;
                j++;
            }
            
            res = Math.max(res, i - j + 1);
        }
        
        return res;
    }
    
    private boolean check(int[] count, int k) {
        int sum = 0, max = 0;
        for (int i : count) {
            sum += i;
            max = Math.max(max, i);
        }
        
        return sum - max <= k;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().characterReplacement("ABAB", 2));
    }
}
