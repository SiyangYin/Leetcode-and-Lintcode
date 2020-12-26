import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param str: the string need to be processed
     * @return: all the valid key-value pairs.
     */
    public List<List<String>> StringSeg(char[] str) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        char sep1 = str[0], sep2 = str[1];
        
        int i = 2;
        while (i < str.length) {
            int j = i, k = i;
            while (j < str.length && str[j] != sep1) {
                if (str[j] == sep2) {
                    k = j;
                }
                
                j++;
            }
            
            if (!(k == i || j - k == 1)) {
                String key = new String(Arrays.copyOfRange(str, i, k));
                String val = new String(Arrays.copyOfRange(str, k + 1, j));
                res.add(Arrays.asList(key, val));
            }
            
            i = j + 1;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().StringSeg(":#aa:3#b:853#:9".toCharArray()));
        System.out.println(new Solution().StringSeg("#:a:3#b:8#c:9".toCharArray()));
    }
}
