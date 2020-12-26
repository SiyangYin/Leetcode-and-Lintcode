import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
    
        for (int i = 0; i <= s.length() - 2; i++) {
            if (s.charAt(i) == '-') {
                continue;
            }
            
            if (s.charAt(i + 1) == '+') {
                sb.setCharAt(i, '-');
                sb.setCharAt(i + 1, '-');
                res.add(sb.toString());
                sb.setCharAt(i + 1, '+');
                sb.setCharAt(i, '+');
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().generatePossibleNextMoves("++++"));
    }
}
