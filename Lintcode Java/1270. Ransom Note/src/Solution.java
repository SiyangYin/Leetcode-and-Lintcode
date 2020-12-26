public class Solution {
    /**
     * @param ransomNote: a string
     * @param magazine: a string
     * @return: whether the ransom note can be constructed from the magazines
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        // Write your code here
        int[] rCount = new int[26], mCount = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            rCount[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            mCount[magazine.charAt(i) - 'a']++;
        }
    
        for (int i = 0; i < 26; i++) {
            if (rCount[i] > mCount[i]) {
                return false;
            }
        }
        
        return true;
    }
}
