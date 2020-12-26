public class Solution {
    /**
     * @param words: the array of string means the list of words
     * @param order: a string indicate the order of letters
     * @return: return true or false
     */
    public boolean isAlienSorted(String[] words, String order) {
        // Write your code here.
        for (int i = 0; i < words.length - 1; i++) {
            if (!check(words[i], words[i + 1], order)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean check(String s1, String s2, String order) {
        boolean hasDiff = false;
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            int idx1 = order.indexOf(c1), idx2 = order.indexOf(c2);
            if (idx1 != idx2) {
                return idx1 < idx2;
            }
        }
        
        return s1.length() <= s2.length();
    }
    
    public static void main(String[] args) {
        String[] words = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(new Solution().isAlienSorted(words, order));
    }
}
