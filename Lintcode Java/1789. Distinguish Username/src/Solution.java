import com.sun.tools.javac.Main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param names: a string array
     * @return: the string array
     */
    public String[] DistinguishUsername(String[] names) {
        // Write your code here
        String[] res = new String[names.length];
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < names.length; i++) {
            map.put(names[i], map.getOrDefault(names[i], 0) + 1);
            int val = map.get(names[i]);
            
            res[i] = val > 1 ? names[i] + (val - 1) : names[i];
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().DistinguishUsername(new String[]{"aa", "bb", "aa"})));
    }
}
