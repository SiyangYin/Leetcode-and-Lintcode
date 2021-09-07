import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param A: a string array
     * @param B: a string array
     * @return: return an string array
     */
    public List<String> wordSubsets(String[] A, String[] B) {
        // write your code here
        int[][] cnts = new int[B.length][26];
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[i].length(); j++) {
                cnts[i][B[i].charAt(j) - 'a']++;
            }
        }
    
        List<String> res = new ArrayList<>();
        for (String s : A) {
            int[] cntS = new int[26];
            for (int i = 0; i < s.length(); i++) {
                cntS[s.charAt(i) - 'a']++;
            }
    
            boolean found = false;
            loop:
            for (int[] cnt : cnts) {
                for (int i = 0; i < 26; i++) {
                    if (cntS[i] < cnt[i]) {
                        found = true;
                        break loop;
                    }
                }
            }
            
            if (!found) {
                res.add(s);
            }
        }
        
        return res;
    }
}
