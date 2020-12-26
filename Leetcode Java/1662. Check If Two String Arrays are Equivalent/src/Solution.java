public class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0, j = 0, idx1 = 0, idx2 = 0;
        while (i < word1.length && j < word2.length) {
            if (idx1 < word1[i].length() && idx2 < word2[j].length() && word1[i].charAt(idx1) != word2[j].charAt(idx2)) {
                return false;
            }
            
            idx1++;
            if (idx1 == word1[i].length()) {
                idx1 = 0;
                i++;
            }
            idx2++;
            if (idx2 == word2[j].length()) {
                idx2 = 0;
                j++;
            }
        }
        
        return i == word1.length && j == word2.length;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().arrayStringsAreEqual(new String[]{"a", "bcd"}, new String[]{"ab", "c"}));
    }
}
