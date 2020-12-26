public class Solution {
    /**
     * @param source: the input string
     * @return: the number of subsequences
     */
    public int countSubsequences(String source) {
        // write your code here
        int aCount = 0, bCount = 0, cCount = 0;
        for (int i = 0; i < source.length(); i++) {
            char ch = source.charAt(i);
            if (ch  == 'a') {
                aCount = 1 + 2 * aCount;
            } else if (ch == 'b') {
                bCount = aCount + 2 * bCount;
            } else {
                cCount = bCount + 2 * cCount;
            }
        }
        
        return cCount;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().countSubsequences("abbc"));
    }
}
