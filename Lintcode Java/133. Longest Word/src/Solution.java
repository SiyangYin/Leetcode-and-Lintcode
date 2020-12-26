import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    public List<String> longestWords(String[] dictionary) {
        // write your code here
        List<String> res = new ArrayList<>();
        for (String s : dictionary) {
            if (res.isEmpty()) {
                res.add(s);
            } else if (s.length() > res.get(0).length()) {
                res.clear();
                res.add(s);
            } else if (s.length() == res.get(0).length()) {
                res.add(s);
            }
        }
        
        return res;
    }
}
