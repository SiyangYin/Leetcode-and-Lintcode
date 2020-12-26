import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows == 1) {
            return s;
        }
    
        List<List<Character>> rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rows.add(new ArrayList<>());
        }
        
        int index = 0, phase = 0;
        while (index < s.length()) {
            while (phase < numRows && index < s.length()) {
                rows.get(phase++).add(s.charAt(index++));
            }
            phase -= 2;
            while (phase >= 0 && index < s.length()) {
                rows.get(phase--).add(s.charAt(index++));
            }
            phase += 2;
        }
        
        StringBuilder res = new StringBuilder();
        for (List<Character> row : rows) {
            for (Character character : row) {
                res.append(character);
            }
        }
        
        return new String(res);
    }
    
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
    
        System.out.println(new Solution().convert(s, numRows));
    }
}
