public class Solution {
    /**
     * @param s: The first string
     * @param t: The second string
     * @return: true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        int[] sChar = new int[256];
        int[] tChar = new int[256];
        for (char c : s.toCharArray()) {
            sChar[c]++;
        }
        for (char c : t.toCharArray()) {
            tChar[c]++;
        }
        for (int i = 0; i < 256; i++) {
            if (sChar[i] != tChar[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().anagram("A big bug bit the little beetle but the little beetle bit the big bug back",
                "A eAe AAgilii eett bihbbigbiteeA A t igibAiggcbleiA  gieabeibleii bA bAt i"));
    }
}
