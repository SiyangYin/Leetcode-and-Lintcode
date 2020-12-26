public class Solution {
    /**
     * @param words: a string array
     * @return: the maximum product
     */
    public int maxProduct(String[] words) {
        // Write your code here
        int n = words.length;
        int[] mark = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                mark[i] |= 1 << words[i].charAt(j) - 'a';
            }
        }
    
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((mark[i] & mark[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        
        return res;
    }
}
