public class Solution {
    /**
     * @param s: the given string
     * @return: if a permutation of the string could form a palindrome
     */
    public boolean canPermutePalindrome(String s) {
        // write your code here
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        
        int odd = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 == 1) {
                odd++;
            }
        }
        
        return odd < 2;
    }
}
