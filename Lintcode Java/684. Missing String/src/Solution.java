import java.util.*;

public class Solution {
    /**
     * @param str1: a given string
     * @param str2: another given string
     * @return: An array of missing string
     */
    public List<String> missingString(String str1, String str2) {
        // Write your code here
        Set<String> set = new HashSet<>(Arrays.asList(str2.split(" ")));
        
        List<String> res = new ArrayList<>();
        for (String s : str1.split(" ")) {
            if (!set.contains(s)) {
                res.add(s);
            }
        }
        
        return res;
    }
}
