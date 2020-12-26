import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        if (A == null || A.length == 0) {
            return res;
        }
        
        int[] resCount = new int[26], count = new int[26];
        Arrays.fill(resCount, Integer.MAX_VALUE);
        
        for (int i = 0; i < A.length; i++) {
            Arrays.fill(count, 0);
            for (int j = 0; j < A[i].length(); j++) {
                count[A[i].charAt(j) - 'a']++;
            }
    
            for (int j = 0; j < 26; j++) {
                resCount[j] = Math.min(resCount[j], count[j]);
            }
        }
    
        for (int i = 0; i < 26; i++) {
            while (resCount[i] > 0) {
                res.add(String.valueOf((char) ('a' + i)));
                resCount[i]--;
            }
        }
        
        return res;
    }
    
    
}
