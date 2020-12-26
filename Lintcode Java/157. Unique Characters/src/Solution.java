import java.util.HashSet;
import java.util.Set;

public class Solution {
    /*
     * @param str: A string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        // write your code here
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (!set.add(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isUnique("abc"));
    }
}