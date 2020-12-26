import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        
        if (digits == null || "".equals(digits)) {
            return res;
        }
        
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc"); map.put('3', "def");
        map.put('4', "ghi"); map.put('5', "jkl");
        map.put('6', "mno"); map.put('7', "pqrs");
        map.put('8', "tuv"); map.put('9', "wxyz");
        
        dfs(digits, 0, map, new StringBuilder(), res);
        
        return res;
    }
    
    private void dfs(String digits, int pos, Map<Character, String> map,
                     StringBuilder sb, List<String> res) {
        if (pos == digits.length()) {
            res.add(sb.toString());
            return;
        }
    
        String button = map.get(digits.charAt(pos));
        for (int i = 0; i < button.length(); i++) {
            sb.append(button.charAt(i));
            dfs(digits, pos + 1, map, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
        System.out.println(new Solution().letterCombinations(""));
    }
    
}
