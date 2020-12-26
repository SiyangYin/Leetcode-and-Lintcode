public class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }
    
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i], s2 = words[i + 1];
            if (!compare(s1, s2, index)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean compare(String s1, String s2, int[] index) {
        int i1 = 0, i2 = 0;
        while (i1 < s1.length() && i2 < s2.length()) {
            if (index[s1.charAt(i1) - 'a'] < index[s2.charAt(i2) - 'a']) {
                return true;
            } else if (index[s1.charAt(i1) - 'a'] > index[s2.charAt(i2) - 'a']) {
                return false;
            }
            i1++;
            i2++;
        }
    
        return s1.length() <= s2.length();
    }
    
    public static void main(String[] args) {
        String[] words = {"hello", "lee"};
        System.out.println(new Solution().isAlienSorted(words, "hl"));
    }
}
