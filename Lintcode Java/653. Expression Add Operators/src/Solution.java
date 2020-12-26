import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param num:    a string contains only digits 0-9
     * @param target: An integer
     * @return: return all possibilities
     */
    public List<String> addOperators(String num, int target) {
        // write your code here
        List<String> res = new ArrayList<>();
        dfs(0, new StringBuilder(), 0, 0, num, target, res);
        return res;
    }
    
    private void dfs(int pos, StringBuilder sb, long cur, long last, String s, int target, List<String> res) {
        if (pos == s.length()) {
            if (cur == target) {
                res.add(sb.toString());
            }
            
            return;
        }
        
        for (int i = pos; i < s.length(); i++) {
            String num = s.substring(pos, i + 1);
            
            if (num.length() > 1 && num.charAt(0) == '0') {
                continue;
            }
            
            long curNum = Long.parseLong(num);
            
            if (pos == 0) {
                sb.append(num);
                dfs(i + 1, sb, curNum, curNum, s, target, res);
                sb.setLength(sb.length() - num.length());
            } else {
                sb.append('+').append(curNum);
                dfs(i + 1, sb, cur + curNum, curNum, s, target, res);
                sb.setLength(sb.length() - 1 - num.length());
                
                sb.append('-').append(curNum);
                dfs(i + 1, sb, cur - curNum, -curNum, s, target, res);
                sb.setLength(sb.length() - 1 - num.length());
                
                sb.append('*').append(curNum);
                dfs(i + 1, sb, cur - last + last * curNum, last * curNum, s, target, res);
                sb.setLength(sb.length() - 1 - num.length());
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().addOperators("123", 6));
        System.out.println(new Solution().addOperators("00", 0));
    }
}
