public class Solution {
    /**
     * @param words: a list of words
     * @param word1: a string
     * @param word2: a string
     * @return: the shortest distance between word1 and word2 in the list
     */
    public int shortestWordDistance(String[] words, String word1, String word2) {
        // Write your code here
        int res = Integer.MAX_VALUE, idx1 = -1, idx2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                idx1 = i;
            }
            if (words[i].equals(word2)) {
                if (word1.equals(word2)) {
                    idx1 = idx2;
                }
                idx2 = i;
            }
            
            if (idx1 != -1 && idx2 != -1) {
                res = Math.min(res, Math.abs(idx1 - idx2));
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        String[] ss = {"practice","makes","perfect","coding","makes"};
        System.out.println(new Solution().shortestWordDistance(ss, "makes", "coding"));
    }
}
