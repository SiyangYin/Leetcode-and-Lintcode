import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    public List<String> letterCombinations(String digits) {
        // write your code here
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return res;
        }
        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 2, idx = 0; i <= 9; i++) {
            int j = i == 7 || i == 9 ? 4 : 3;
            for (int k = 0; k < j; k++) {
                map.putIfAbsent(i, new ArrayList<>());
                map.get(i).add((char) ('a' + idx++));
            }
        }
        dfs(digits, 0, new StringBuilder(), map, res);
        return res;
    }
    
    private void dfs(String digits, int pos, StringBuilder cur, Map<Integer, List<Character>> map, List<String> res) {
        if (pos == digits.length()) {
            res.add(cur.toString());
            return;
        }
        
        for (char c : map.get(digits.charAt(pos) - '0')) {
            cur.append(c);
            dfs(digits, pos + 1, cur, map, res);
            cur.setLength(cur.length() - 1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }
}
