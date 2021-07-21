import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    
    private int idx;
    
    public String countOfAtoms(String formula) {
        idx = 0;
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : new TreeMap<>(dfs(formula)).entrySet()) {
            sb.append(entry.getKey());
            if (entry.getValue() > 1) {
                sb.append(entry.getValue());
            }
        }
        
        return sb.toString();
    }
    
    private Map<String, Integer> dfs(String s) {
        Map<String, Integer> res = new HashMap<>();
        while (idx < s.length()) {
            char ch = s.charAt(idx);
            if (ch == '(') {
                idx++;
                Map<String, Integer> map = dfs(s);
                idx++;
                int cnt = 1, j = idx;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                
                if (j > idx) {
                    cnt = Integer.parseInt(s.substring(idx, j));
                    idx = j;
                }
    
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    String e = entry.getKey();
                    int val = entry.getValue();
                    res.put(e, res.getOrDefault(e, 0) + cnt * val);
                }
            } else if (ch == ')') {
                break;
            } else {
                int j = idx + 1;
                if (j < s.length() && Character.isLowerCase(s.charAt(j))) {
                    j++;
                }
                String e = s.substring(idx, j);
                idx = j;
                int cnt = 1;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                if (j > idx) {
                    cnt = Integer.parseInt(s.substring(idx, j));
                    idx = j;
                }
                
                res.put(e, res.getOrDefault(e, 0) + cnt);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().countOfAtoms("H2O"));
        System.out.println(new Solution().countOfAtoms("Mg(OH)2"));
        System.out.println(new Solution().countOfAtoms("K4(ON(SO3)2)2"));
    }
}
