import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] str = s.toCharArray();
        int i = 0, j = str.length - 1;
        while (i < j) {
            while (i < j && !vowels.contains(str[i])) {
                i++;
            }
            while (i < j && !vowels.contains(str[j])) {
                j--;
            }
            
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
            
            i++;
            j--;
        }
        
        return new String(str);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().reverseVowels("hello"));
    }
}
