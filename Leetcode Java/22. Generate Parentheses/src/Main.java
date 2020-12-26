import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static String[] luckyNumbers(String num, int target) {
        List<String> res = new ArrayList<>();
        
        dfs(num, target, 0, 0, 0, new StringBuilder(), res);
        
        String[] ans = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        
        return ans;
    }
    
    private static void dfs(String num, long target, int pos, long curRes, long last, StringBuilder sb, List<String> res) {
        if (pos == num.length()) {
            if (curRes == target) {
                res.add(sb.substring(1, sb.length()));
            }
            
            return;
        }
        
        for (int i = pos + 1; i <= num.length(); i++) {
            String cutNum = num.substring(pos, i);
            if (cutNum.startsWith("0") && !cutNum.equals("0")) {
                break;
            }
            // cut the current number
            long cur = Long.parseLong(cutNum);
            
            // + cutNum
            sb.append('+').append(cutNum);
            dfs(num, target, i, curRes + cur, cur, sb, res);
            sb.setLength(sb.length() - cutNum.length() - 1);
            
            if (pos != 0) {
    
                // - cutNum
                sb.append('-').append(cutNum);
                dfs(num, target, i, curRes - cur, -cur, sb, res);
                sb.setLength(sb.length() - cutNum.length() - 1);
    
                // * cutNum
                sb.append('*').append(cutNum);
                dfs(num, target, i, curRes - last + last * cur, last * cur, sb, res);
                sb.setLength(sb.length() - cutNum.length() - 1);
    
                // / cutNum
                if (cur != 0 && last % cur == 0) {
                    sb.append('/').append(cutNum);
                    dfs(num, target, i, curRes - last + last / cur, last / cur, sb, res);
                    sb.setLength(sb.length() - cutNum.length() - 1);
                }
            }
            
        }
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(luckyNumbers("123456", 1)));
    }
}
