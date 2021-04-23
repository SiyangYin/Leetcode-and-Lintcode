import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            if (Character.isDigit(word.charAt(i))) {
                if (word.charAt(i) == '0') {
                    if (i + 1 == word.length() || !Character.isDigit(word.charAt(i + 1))) {
                        set.add("0");
                    }
                } else {
                    int j = i;
                    while (j < word.length() && Character.isDigit(word.charAt(j))) {
                        j++;
                    }
    
                    set.add(word.substring(i, j));
                    i = j;
                }
            }
        }
        
        return set.size();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().numDifferentIntegers("0a0"));
    }
}
