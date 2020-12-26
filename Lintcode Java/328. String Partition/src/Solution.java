import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * @param s: a string
     * @return:  an array containing the length of each part
     */
    public List<Integer> splitString(String s) {
        // write your code here.
        List<Integer> res = new ArrayList<>();
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
    
        int pos = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            pos = Math.max(pos, map.get(s.charAt(i)));
            
            if (i == pos) {
                res.add(i - j + 1);
                j = pos + 1;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().splitString("MPMPCPMCMDEFEGDEHINHKLIN"));
    }
}
