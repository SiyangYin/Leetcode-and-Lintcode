public class Solution {
    /**
     * @param s: the string s
     * @param k: the maximum length of substring
     * @return: return the least number of substring
     */
    public int getAns(String s, int k) {
        // Write your code here
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i, l = k;
            while (j < s.length() && s.charAt(j) == s.charAt(i) && l > 0) {
                j++;
                l--;
            }
            
            i = j - 1;
            res++;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().getAns("aabbbc", 2));
    }
}
