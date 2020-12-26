import java.util.List;

public class Solution {
    /**
     * @param words: the words given.
     * @param wordA: the first word you need to find.
     * @param wordB: the second word you need to find.
     * @return: return the spacing of the closest wordA and wordB.
     */
    public int wordSpacing(List<String> words, String wordA, String wordB) {
        // write your code here.
        if (words == null || words.isEmpty()) {
            return -1;
        }
        
        int res = words.size(), posA = -1, posB = -1;
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).equals(wordA)) {
                posA = i;
            }
            if (words.get(i).equals(wordB)) {
                posB = i;
            }
            
            if (posA != -1 && posB != -1) {
                res = Math.min(res, Math.abs(posA - posB));
            }
        }
        
        return res == words.size() ? -1 : res;
    }
}
