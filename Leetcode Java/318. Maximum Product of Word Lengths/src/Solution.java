public class Solution {
    public int maxProduct(String[] words) {
        int[] bits = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                bits[i] |= 1 << (word.charAt(j) - 'a');
            }
        }
        
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if ((bits[i] & bits[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        
        return res;
    }
}
