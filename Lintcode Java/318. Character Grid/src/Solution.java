import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    /**
     * @param A: A string
     * @param B: A string
     * @return: A string array
     */
    public List<String> characterGrid(String A, String B) {
        // write your code here.
        List<String> res = new ArrayList<>();
        Set<Character> set = new HashSet<>();
    
        for (int i = 0; i < B.length(); i++) {
            set.add(B.charAt(i));
        }
    
        int posA = -1;
        for (int i = 0; i < A.length(); i++) {
            if (set.contains(A.charAt(i))) {
                posA = i;
                break;
            }
        }
        
        int posB = B.indexOf(A.charAt(posA));
        for (int i = 0; i < B.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < A.length(); j++) {
                if (j != posA) {
                    sb.append('.');
                } else {
                    sb.append(B.charAt(i));
                }
            }
            
            res.add(sb.toString());
        }
        
        res.set(posB, A);
        return res;
    }
    
    public static void main(String[] args) {
        List<String> list = new Solution().characterGrid("TRIANGEL", "RECTANGLE");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
