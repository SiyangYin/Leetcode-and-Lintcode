import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param s: the given string
     * @return: all the possible states of the string after one valid move
     */
    public List<String> generatePossibleNextMoves(String s) {
        // write your code here
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                res.add(s.substring(0, i) + "--" + s.substring(i + 2));
            }
        }
        
        return res;
    }
}
