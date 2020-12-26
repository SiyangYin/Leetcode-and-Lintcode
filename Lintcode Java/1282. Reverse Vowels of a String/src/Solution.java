import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param s: a string
     * @return: reverse only the vowels of a string
     */
    public String reverseVowels(String s) {
        // write your code here
        if (s == null || s.isEmpty()) {
            return s;
        }
        
        char[] string = s.toCharArray();
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int l = 0, r = string.length - 1;
        while (l < r) {
            while (l < r && !set.contains(string[l])) {
                l++;
            }
            while (l < r && !set.contains(string[r])) {
                r--;
            }
            swap(string, l++, r--);
        }
        
        return new String(string);
    }
    
    private void swap(char[] string, int i, int j) {
        char tmp = string[i];
        string[i] = string[j];
        string[j] = tmp;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().reverseVowels("hello"));
    }
}
